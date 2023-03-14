package com.zero.logisticsbackend.controller;

import com.zero.logisticsbackend.model.vo.*;
import com.zero.logisticsbackend.service.ProvinceLogisticsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProvinceLogisticsInfoController
 *
 * @author ZERO
 * @date 2023/3/14
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/province")
public class ProvinceLogisticsInfoController {

    private final ProvinceLogisticsInfoService provinceLogisticsInfoService;

    @GetMapping("/logistics/volume/{provinceName}")
    public List<LogisticsVolumeInfoVO> getLogisticsVolumeInfoVOList(@PathVariable String provinceName) {
        return provinceLogisticsInfoService.getLogisticsVolumeInfoVOList(provinceName);
    }

    @GetMapping("/logistics/income/{provinceName}")
    public List<LogisticsIncomeInfoVO> getLogistiosIncomeInfoVOList(@PathVariable String provinceName) {
        return provinceLogisticsInfoService.getLogisticsIncomeInfoVOList(provinceName);
    }

    @GetMapping("/industry/scale/{provinceName}/{year}")
    public IndustryScaleInfoVO getIndustryScaleInfoVO(@PathVariable String provinceName, @PathVariable Integer year) {
        return provinceLogisticsInfoService.getIndustryScaleInfoVO(provinceName, year);
    }

    @GetMapping("/industry/cycle/{provinceName}/{beginYear}/{endYear}")
    public List<IndustryCycleInfoVO> getIndustryCycleInfoVOList(@PathVariable String provinceName, @PathVariable Integer beginYear, @PathVariable Integer endYear) {
        return provinceLogisticsInfoService.getIndustryCycleInfoVOList(provinceName, beginYear, endYear);
    }

    @GetMapping("/storage/{provinceName}/{year}")
    public StorageVolumeInfoVO getStorageVolumeInfoVO(@PathVariable String provinceName, @PathVariable Integer year) {
        return provinceLogisticsInfoService.getStorageVolumeInfoVO(provinceName, year);
    }

    @GetMapping("/transport/volume/{provinceName}/{year}")
    public TransportVolumeInfoVO getTransportVolumeInfoVO(@PathVariable String provinceName, @PathVariable Integer year) {
        return provinceLogisticsInfoService.getTransportVolumeInfoVO(provinceName, year);
    }

}
