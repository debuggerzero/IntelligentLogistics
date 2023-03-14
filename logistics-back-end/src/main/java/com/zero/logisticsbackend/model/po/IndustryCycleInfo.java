package com.zero.logisticsbackend.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 行业景气信息
 *
 * @author ZERO
 * @date 2023/3/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndustryCycleInfo {

    private Integer month;

    private Double indCycle;

}
