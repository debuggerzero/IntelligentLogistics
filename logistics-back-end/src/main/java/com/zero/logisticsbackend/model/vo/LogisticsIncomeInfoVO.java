package com.zero.logisticsbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 物流收入
 *
 * @author ZERO
 * @date 2023/3/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogisticsIncomeInfoVO {

    private Integer id;

    private Integer year;

    private Double logIncome;

    private Double logIncomeIncrease;

}
