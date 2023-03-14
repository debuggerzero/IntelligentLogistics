package com.zero.logisticsbackend.model.vo;

import com.zero.logisticsbackend.model.po.IndustryCycleInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 行业景气
 *
 * @author ZERO
 * @date 2023/3/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndustryCycleInfoVO {

    private Integer id;

    private Integer year;

    private List<IndustryCycleInfo> industryCycle;

}
