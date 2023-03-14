package com.zero.logisticsbackend.model.convert;

import com.zero.logisticsbackend.model.po.CountryLogisticsInfo;
import com.zero.logisticsbackend.model.po.ProvinceLogisticsInfo;
import com.zero.logisticsbackend.model.vo.LogisticsVolumeInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * --> LogisticsVolumeInfoVO
 *
 * @author ZERO
 * @date 2023/3/9
 */
@Mapper
public interface ToLogisticsVolumeInfoVO {

    ToLogisticsVolumeInfoVO CONVERT = Mappers.getMapper(ToLogisticsVolumeInfoVO.class);

    /**
     * CountryLogisticsInfo --> LogisticsVolumeInfoVO
     * @param countryLogisticsInfo 国家物流数据信息
     * @return LogisticsVolumeInfoVO
     */
    LogisticsVolumeInfoVO toLogisticsVolumeInfo(CountryLogisticsInfo countryLogisticsInfo);

    /**
     * ProvinceLogisticsInfo --> LogisticsVolumeInfoVO
     * @param provinceLogisticsInfo 省物流数据信息
     * @return LogisticsVolumeInfoVO
     */
    LogisticsVolumeInfoVO toLogisticsVolumeInfo(ProvinceLogisticsInfo provinceLogisticsInfo);

}
