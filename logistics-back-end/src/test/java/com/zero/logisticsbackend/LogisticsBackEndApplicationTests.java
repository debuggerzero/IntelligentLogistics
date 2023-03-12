package com.zero.logisticsbackend;

import com.zero.logisticsbackend.model.po.ProvinceInfo;
import com.zero.logisticsbackend.model.vo.*;
import com.zero.logisticsbackend.repo.ProvinceInfoRepo;
import com.zero.logisticsbackend.service.CountryLogisticsInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@SpringBootTest
class LogisticsBackEndApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource(name = "provinceInfoRepoImpl")
    private ProvinceInfoRepo provinceInfoRepo;

    @Test
    void testProvinceInfo() {
        Collection<ProvinceInfo> provinceInfoList = provinceInfoRepo.getProvinceInfoList();
        System.out.println(provinceInfoList);
    }

    @Resource
    private CountryLogisticsInfoService countryLogisticsInfoService;

    @Test
    void testLogisticsVolumeInfo() {
        List<LogisticsVolumeInfoVO> logisticsVolumeInfoList = countryLogisticsInfoService.getLogisticsVolumeInfoVOList();
        System.out.println(logisticsVolumeInfoList);
    }

    @Test
    void testLogisticsIncomeInfo() {
        List<LogisticsIncomeInfoVO> logisticsIncomeInfoVOList = countryLogisticsInfoService.getLogisticsIncomeInfoVOList();
        System.out.println(logisticsIncomeInfoVOList);
    }

    @Test
    void testTransportVolumeInfo() {
        TransportVolumeInfoVO transportVolumeInfoVO = countryLogisticsInfoService.getTransportVolumeInfoVO(2021);
        System.out.println(transportVolumeInfoVO);
    }

    @Test
    void testOperationVolumeInfo() {
        List<OperationVolumeInfoVO> operationVolumeInfoVOList = countryLogisticsInfoService.getOperationVolumeInfoVOList(2019, 2021);
        System.out.println(operationVolumeInfoVOList);
    }

    @Test
    void testSubareaLogisticsInfo() {
        SubareaLogisticsInfoVO subareaLogisticsInfoVO = countryLogisticsInfoService.getSubareaLogisticsInfoVO(2021);
        System.out.println(subareaLogisticsInfoVO);
    }

    @Test
    void testIndustryScaleInfo() {
        IndustryScaleInfoVO industryScaleInfoVO = countryLogisticsInfoService.getIndustryScaleInfoVO(2021);
        System.out.println(industryScaleInfoVO);
    }

}
