package com.zero.logisticsbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 物流分区占比信息
 *
 * @author ZERO
 * @date 2023/3/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubareaLogisticsInfoVO {

    private Integer id;

    private Integer year;

    private SubareaLogisticsVolumeVO subareaLogisticsVolume;

    private SubareaLogisticsIncomeVO subareaLogisticsIncome;

}
