package com.zero.logisticsbackend.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 省物流信息
 *
 * @author ZERO
 * @date 2023/3/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceLogisticsInfo {

    private Integer id;

    private Integer year;

    private Double logVolume;

    private Double indScale;

    private Double lTranVolume;

    private Double wTranVolume;

    private Double aTranVolume;

    private Double logIncome;

    private List<IndustryCycleInfo> industryCycle;

    private Double sfStoVolume;

    private Double djStoVolume;

    private Double emsStoVolume;

    private Double otherStoVolume;

}
