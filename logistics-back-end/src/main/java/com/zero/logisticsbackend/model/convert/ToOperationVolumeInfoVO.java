package com.zero.logisticsbackend.model.convert;

import com.zero.logisticsbackend.model.po.CountryLogisticsInfo;
import com.zero.logisticsbackend.model.vo.OperationVolumeInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * CountryLogisticsInfo --> OperationVolumeInfoVO
 *
 * @author ZERO
 * @date 2023/3/11
 */
@Mapper
public interface ToOperationVolumeInfoVO {

    ToOperationVolumeInfoVO CONVERT = Mappers.getMapper(ToOperationVolumeInfoVO.class);

    /**
     * CountryLogisticsInfo --> OperationVolumeInfoVO
     * @param countryLogisticsInfo countryLogisticsInfo
     * @return OperationVolumeInfoVO
     */
    OperationVolumeInfoVO toOperationVolumeInfoVO(CountryLogisticsInfo countryLogisticsInfo);

}
