package com.zero.logisticsbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地域业务量
 *
 * @author ZERO
 * @date 2023/3/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationVolumeInfoVO {

    private Integer id;

    private Integer year;

    private Double localOpVolume;

    private Double remoteOpVolume;

    private Double internationalOpVolume;

}
