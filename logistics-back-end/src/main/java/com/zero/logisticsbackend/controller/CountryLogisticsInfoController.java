package com.zero.logisticsbackend.controller;

import com.zero.logisticsbackend.model.vo.*;
import com.zero.logisticsbackend.service.CountryLogisticsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CountryLogisticsInfoController
 *
 * @author ZERO
 * @date 2023/3/10
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryLogisticsInfoController {

    private final CountryLogisticsInfoService countryLogisticsInfoService;

    @GetMapping("/logistics/volume")
    List<LogisticsVolumeInfoVO> getLogisticsVolumeInfoVOList() {
        return countryLogisticsInfoService.getLogisticsVolumeInfoVOList();
    }

    @GetMapping("/logistics/income")
    List<LogisticsIncomeInfoVO> getLogisticsIncomeInfoVOList() {
        return countryLogisticsInfoService.getLogisticsIncomeInfoVOList();
    }

    @GetMapping("/transport/volume/{year}")
    TransportVolumeInfoVO getTransportVolumeInfoVO(@PathVariable Integer year) {
        return countryLogisticsInfoService.getTransportVolumeInfoVO(year);
    }

    @GetMapping("/operation/volume/{beginYear}/{endYear}")
    List<OperationVolumeInfoVO> getOperationVolumeInfoVOList(@PathVariable Integer beginYear, @PathVariable Integer endYear) {
        return countryLogisticsInfoService.getOperationVolumeInfoVOList(beginYear, endYear);
    }

    @GetMapping("/logistics/subarea/{year}")
    SubareaLogisticsInfoVO getSubareaLogisticsInfoVO(@PathVariable Integer year) {
        return countryLogisticsInfoService.getSubareaLogisticsInfoVO(year);
    }

    @GetMapping("/industry/scale/{year}")
    IndustryScaleInfoVO getIndustryScaleInfoVO(@PathVariable Integer year) {
        return countryLogisticsInfoService.getIndustryScaleInfoVO(year);
    }

}
