package com.zero.logisticsbackend.service;

import com.zero.logisticsbackend.exception.AssertionException;
import com.zero.logisticsbackend.model.convert.*;
import com.zero.logisticsbackend.model.po.CountryLogisticsInfo;
import com.zero.logisticsbackend.model.vo.*;
import com.zero.logisticsbackend.repo.CountryLogisticsInfoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * CountryLogisticsInfoService
 *
 * @author ZERO
 * @date 2023/3/9
 */
@Service
@RequiredArgsConstructor
public class CountryLogisticsInfoService {

    @Resource(name = "countryLogisticsInfoRepoImpl")
    private final CountryLogisticsInfoRepo countryLogisticsInfoRepo;

    @Cacheable("countryLogisticsInfoList")
    public List<CountryLogisticsInfo> getCountryLogisticsInfoList() {
        return countryLogisticsInfoRepo.getCountryLogisticsInfoList();
    }

    @Cacheable("countryLogisticsVolumeInfoList")
    public List<LogisticsVolumeInfoVO> getLogisticsVolumeInfoVOList() {

        Collection<CountryLogisticsInfo> countryLogisticsInfoList = getCountryLogisticsInfoList();
        List<LogisticsVolumeInfoVO> logisticsVolumeInfoVOList = countryLogisticsInfoList
                .stream()
                .map(ToLogisticsVolumeInfoVO.CONVERT::toLogisticsVolumeInfo)
                .sorted(Comparator.comparing(LogisticsVolumeInfoVO::getYear))
                .collect(Collectors.toList());

        int len = logisticsVolumeInfoVOList.size();
        logisticsVolumeInfoVOList.get(0).setLogVolumeIncrease(0.0);
        for (int i = 1; i < len; i++) {
            Double target = logisticsVolumeInfoVOList.get(i).getLogVolume();
            Double old = logisticsVolumeInfoVOList.get(i - 1).getLogVolume();
            logisticsVolumeInfoVOList.get(i).setLogVolumeIncrease((target - old) / old);
        }

        return logisticsVolumeInfoVOList;
    }

    @Cacheable("countryLogisticsIncomeInfoVOList")
    public List<LogisticsIncomeInfoVO> getLogisticsIncomeInfoVOList() {

        List<CountryLogisticsInfo> countryLogisticsInfoList = getCountryLogisticsInfoList();
        List<LogisticsIncomeInfoVO> logisticsIncomeInfoVOList = countryLogisticsInfoList
                .stream()
                .map(ToLogisticsIncomeInfoVO.CONVERT::toLogisticsIncomeInfo)
                .sorted(Comparator.comparing(LogisticsIncomeInfoVO::getYear))
                .collect(Collectors.toList());

        int len = logisticsIncomeInfoVOList.size();
        logisticsIncomeInfoVOList.get(0).setLogIncomeIncrease(0.0);
        for (int i = 1; i < len; i++) {
            Double target = logisticsIncomeInfoVOList.get(i).getLogIncome();
            Double old = logisticsIncomeInfoVOList.get(i - 1).getLogIncome();
            logisticsIncomeInfoVOList.get(i).setLogIncomeIncrease((target - old) / old);
        }

        return logisticsIncomeInfoVOList;
    }

    @Cacheable("countryTransportVolumeInfoVO")
    public TransportVolumeInfoVO getTransportVolumeInfoVO(Integer year) {

        List<CountryLogisticsInfo> countryLogisticsInfoList = getCountryLogisticsInfoList();
        Map<Integer, TransportVolumeInfoVO> transportVolumeInfoMap = countryLogisticsInfoList
                .stream()
                .map(ToTransportVolumeInfoVO.CONVERT::toTransportVolumeInfoVO)
                .collect(Collectors.toMap(TransportVolumeInfoVO::getYear, e -> e));

        if (Objects.isNull(transportVolumeInfoMap.get(year))) {
            throw new AssertionException(500001, "该年数据不存在...");
        }

        return transportVolumeInfoMap.get(year);
    }

    @Cacheable("countryOperationVolumeInfoVOList")
    public List<OperationVolumeInfoVO> getOperationVolumeInfoVOList(Integer beginYear, Integer endYear) {
        if (beginYear > endYear) {
            throw new AssertionException(500001, "参数错误...");
        }
        List<CountryLogisticsInfo> countryLogisticsInfoList = getCountryLogisticsInfoList();

        return countryLogisticsInfoList
                .stream()
                .filter(countryLogisticsInfo ->
                        countryLogisticsInfo.getYear() >= beginYear && countryLogisticsInfo.getYear() <= endYear)
                .map(ToOperationVolumeInfoVO.CONVERT::toOperationVolumeInfoVO)
                .sorted(Comparator.comparing(OperationVolumeInfoVO::getYear))
                .collect(Collectors.toList());
    }

    @Cacheable("countrySubareaLogisticsInfoVO")
    public SubareaLogisticsInfoVO getSubareaLogisticsInfoVO(Integer year) {

        List<CountryLogisticsInfo> countryLogisticsInfoList = getCountryLogisticsInfoList();
        Map<Integer, SubareaLogisticsInfoVO> subareaLogisticsInfoMap = countryLogisticsInfoList
                .stream()
                .map(ToSubareaLogisticsInfoVO.CONVERT::toSubareaLogisticsInfoVO)
                .collect(Collectors.toMap(SubareaLogisticsInfoVO::getYear, e -> e));

        if (Objects.isNull(subareaLogisticsInfoMap.get(year))) {
            throw new AssertionException(500001, "该年数据不存在...");
        }

        return subareaLogisticsInfoMap.get(year);
    }

    @Cacheable("countryIndustryScaleInfoVOList")
    public IndustryScaleInfoVO getIndustryScaleInfoVO(Integer year) {

        List<CountryLogisticsInfo> countryLogisticsInfoList = getCountryLogisticsInfoList();
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

}
