package com.zero.logisticsbackend.model.convert;

import com.zero.logisticsbackend.model.po.CountryLogisticsInfo;
import com.zero.logisticsbackend.model.vo.TransportVolumeInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * CountryLogisticsInfo --> TransportVolumeInfoVO
 *
 * @author ZERO
 * @date 2023/3/10
 */
@Mapper
public interface ToTransportVolumeInfoVO {

    ToTransportVolumeInfoVO CONVERT = Mappers.getMapper(ToTransportVolumeInfoVO.class);

    /**
     * CountryLogisticsInfo --> TransportVolumeInfoVO
     * @param countryLogisticsInfo countryLogisticsInfo
     * @return ToTransportVolumeInfoVO
     */
    TransportVolumeInfoVO toTransportVolumeInfoVO(CountryLogisticsInfo countryLogisticsInfo);

}
