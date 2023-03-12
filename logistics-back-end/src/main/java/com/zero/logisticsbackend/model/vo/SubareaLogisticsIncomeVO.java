package com.zero.logisticsbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分区物流收入
 *
 * @author ZERO
 * @date 2023/3/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubareaLogisticsIncomeVO {

    private Double eLogIncome;

    private Double mLogIncome;

    private Double wLogIncome;

}
