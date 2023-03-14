package com.zero.logisticsbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 入库量
 *
 * @author ZERO
 * @date 2023/3/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageVolumeInfoVO {

    private Integer id;

    private Integer year;

    private Double sfStoVolume;

    private Double djStoVolume;

    private Double emsStoVolume;

    private Double otherStoVolume;

}
