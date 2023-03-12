package com.zero.logisticsbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 行业规模信息
 *
 * @author ZERO
 * @date 2023/3/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndustryScaleInfoVO {

    private Integer id;

    private Integer year;

    private Double indScale;

    private Double indScaleIncrease;

}
