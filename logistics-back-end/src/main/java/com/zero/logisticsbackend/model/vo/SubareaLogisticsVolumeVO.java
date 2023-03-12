package com.zero.logisticsbackend.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分区业务量
 *
 * @author ZERO
 * @date 2023/3/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubareaLogisticsVolumeVO {

    private Double eLogVolume;

    private Double mLogVolume;

    private Double wLogVolume;

}
