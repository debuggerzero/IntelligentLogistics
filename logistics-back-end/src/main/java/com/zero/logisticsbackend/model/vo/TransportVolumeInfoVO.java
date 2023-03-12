package com.zero.logisticsbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 运输量信息
 *
 * @author ZERO
 * @date 2023/3/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportVolumeInfoVO {

    private Integer id;

    private Integer year;

    private Double lTranVolume;

    private Double wTranVolume;

    private Double aTranVolume;

}
