package com.zero.logisticsbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 物流量
 *
 * @author ZERO
 * @date 2023/3/9
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogisticsVolumeInfoVO {

    private Integer id;

    private Integer year;

    private Double logVolume;

    private Double logVolumeIncrease;

}
