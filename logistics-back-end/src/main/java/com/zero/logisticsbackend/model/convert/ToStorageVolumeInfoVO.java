package com.zero.logisticsbackend.model.convert;

import com.zero.logisticsbackend.model.po.ProvinceLogisticsInfo;
import com.zero.logisticsbackend.model.vo.StorageVolumeInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * --> StorageVolumeInfoVO
 *
 * @author ZERO
 * @date 2023/3/14
 */
@Mapper
public interface ToStorageVolumeInfoVO {

    ToStorageVolumeInfoVO CONVERT = Mappers.getMapper(ToStorageVolumeInfoVO.class);

    /**
     * ProvinceLogisticsInfo --> StorageVolumeInfoVO
     * @param provinceLogisticsInfo ProvinceLogisticsInfo
     * @return StorageVolumeInfoVO
     */
    StorageVolumeInfoVO toStorageVolumeInfoVO(ProvinceLogisticsInfo provinceLogisticsInfo);

}
