package com.zero.logisticsbackend.service;

import com.zero.logisticsbackend.exception.AssertionException;
import com.zero.logisticsbackend.model.convert.*;
import com.zero.logisticsbackend.model.po.ProvinceLogisticsInfo;
import com.zero.logisticsbackend.model.vo.*;
import com.zero.logisticsbackend.repo.ProvinceLogisticsInfoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ProvinceLogisticsInfoService
 *
 * @author ZERO
 * @date 2023/3/13
 */
@RequiredArgsConstructor
@Service
public class ProvinceLogisticsInfoService {

    @Resource(name = "provinceLogisticsInfoRepoImpl")
    private final ProvinceLogisticsInfoRepo provinceLogisticsInfoRepo;

    @Cacheable("provinceLogisticsInfoList")
    public List<ProvinceLogisticsInfo> getProvinceLogisticsInfoList(String provinceName) {
        return provinceLogisticsInfoRepo.getProvinceLogisticsInfoList(provinceName);
    }

    @Cacheable("provinceLogisticsVolumeInfoVOList")
    public List<LogisticsVolumeInfoVO> getLogisticsVolumeInfoVOList(String provinceName) {

        List<ProvinceLogisticsInfo> provinceLogisticsInfoList = getProvinceLogisticsInfoList(provinceName);
        List<LogisticsVolumeInfoVO> logisticsVolumeInfoVOList = provinceLogisticsInfoList
                .stream()
                .map(ToLogisticsVolumeInfoVO.CONVERT::toLogisticsVolumeInfo)
                .sorted(Comparator.comparing(LogisticsVolumeInfoVO::getYear))
                .collect(Collectors.toList());

        int size = logisticsVolumeInfoVOList.size();
        logisticsVolumeInfoVOList.get(0).setLogVolumeIncrease(0.0);
        for (int i = 1; i < size; i++) {
            Double target = logisticsVolumeInfoVOList.get(i).getLogVolume();
            Double old = logisticsVolumeInfoVOList.get(i - 1).getLogVolume();
            logisticsVolumeInfoVOList.get(i).setLogVolumeIncrease((target - old) / old);
        }

        return logisticsVolumeInfoVOList;
    }

    @Cacheable("provinceLogisticsIncomeInfoVOList")
    public List<LogisticsIncomeInfoVO> getLogisticsIncomeInfoVOList(String provinceName) {

        List<ProvinceLogisticsInfo> provinceLogisticsInfoList = getProvinceLogisticsInfoList(provinceName);
        List<LogisticsIncomeInfoVO> logisticsIncomeInfoVOList = provinceLogisticsInfoList
                .stream()
                .map(ToLogisticsIncomeInfoVO.CONVERT::toLogisticsIncomeInfo)
                .sorted(Comparator.comparing(LogisticsIncomeInfoVO::getYear))
                .collect(Collectors.toList());

        int size = logisticsIncomeInfoVOList.size();
        logisticsIncomeInfoVOList.get(0).setLogIncomeIncrease(0.0);
        for (int i = 1; i < size; i++) {
            Double target = logisticsIncomeInfoVOList.get(i).getLogIncome();
            Double old = logisticsIncomeInfoVOList.get(i - 1).getLogIncome();
            logisticsIncomeInfoVOList.get(i).setLogIncomeIncrease((target - old) / old);
        }

        return logisticsIncomeInfoVOList;
    }

    @Cacheable("provinceIndustryScaleInfoVOList")
    public IndustryScaleInfoVO getIndustryScaleInfoVO(String provinceName, Integer year) {

        List<ProvinceLogisticsInfo> countryLogisticsInfoList = getProvinceLogisticsInfoList(provinceName);
        List<IndustryScaleInfoVO> industryScaleInfoVOList = countryLogisticsInfoList
                .stream()
                .map(ToIndustryScaleInfoVO.CONVERT::toIndustryScaleInfoVO)
                .sorted(Comparator.comparing(IndustryScaleInfoVO::getYear))
                .collect(Collectors.toList());

        int len = industryScaleInfoVOList.size();
        industryScaleInfoVOList.get(0).setIndScaleIncrease(0.0);
        for (int i = 1; i < len; i++) {
            Double target = industryScaleInfoVOList.get(i).getIndScale();
            Double old = industryScaleInfoVOList.get(i - 1).getIndScale();
            industryScaleInfoVOList.get(i).setIndScaleIncrease((target - old) / old);
        }

        Map<Integer, IndustryScaleInfoVO> integerIndustryScaleInfoMap = industryScaleInfoVOList
                .stream().collect(Collectors.toMap(IndustryScaleInfoVO::getYear, e -> e));

        if (Objects.isNull(integerIndustryScaleInfoMap.get(year))) {
            throw new AssertionException(500001, "该年数据不存在...");
        }

        return integerIndustryScaleInfoMap.get(year);
    }

    @Cacheable("provinceIndustryCycleInfoVOList")
    public List<IndustryCycleInfoVO> getIndustryCycleInfoVOList(String provinceName, Integer beginYear, Integer endYear) {

        if (beginYear > endYear) {
            throw new AssertionException(500001, "参数错误...");
        }

        List<ProvinceLogisticsInfo> provinceLogisticsInfoList = getProvinceLogisticsInfoList(provinceName);

        return provinceLogisticsInfoList
                .stream()
                .filter(provinceLogisticsInfo -> provinceLogisticsInfo.getYear() >= beginYear && provinceLogisticsInfo.getYear() <= endYear)
                .map(ToIndustryCycleInfoVO.CONVERT::toIndustryCycleInfoVO)
                .sorted(Comparator.comparing(IndustryCycleInfoVO::getYear))
                .collect(Collectors.toList());
    }

    @Cacheable("provinceStorageVolumeInfoVO")
    public StorageVolumeInfoVO getStorageVolumeInfoVO(String provinceName, Integer year) {
        List<ProvinceLogisticsInfo> provinceLogisticsInfoList = getProvinceLogisticsInfoList(provinceName);
        Map<Integer, StorageVolumeInfoVO> storageVolumeInfoMap = provinceLogisticsInfoList
                .stream()
                .map(ToStorageVolumeInfoVO.CONVERT::toStorageVolumeInfoVO)
                .collect(Collectors.toMap(StorageVolumeInfoVO::getYear, e->e));

        if (Objects.isNull(storageVolumeInfoMap.get(year))) {
            throw new AssertionException(500001, "该年数据不存在...");
        }

        return storageVolumeInfoMap.get(year);
    }

    @Cacheable("provinceTransportVolumeInfoVO")
    public TransportVolumeInfoVO getTransportVolumeInfoVO(String provinceName, Integer year) {
        List<ProvinceLogisticsInfo> provinceLogisticsInfoList = getProvinceLogisticsInfoList(provinceName);
        Map<Integer, TransportVolumeInfoVO> transportVolumeInfoMap = provinceLogisticsInfoList
                .stream()
                .map(ToTransportVolumeInfoVO.CONVERT::toTransportVolumeInfoVO)
                .collect(Collectors.toMap(TransportVolumeInfoVO::getYear, e->e));

        if (Objects.isNull(transportVolumeInfoMap.get(year))) {
            throw new AssertionException(500001, "该年数据不存在...");
        }

        return transportVolumeInfoMap.get(year);
    }

}