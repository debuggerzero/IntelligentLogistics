package com.zero.logisticsbackend.model.convert;

import com.zero.logisticsbackend.model.po.CountryLogisticsInfo;
import com.zero.logisticsbackend.model.po.ProvinceLogisticsInfo;
import com.zero.logisticsbackend.model.vo.IndustryScaleInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * --> IndustryScaleInfoVO
 *
 * @author ZERO
 * @date 2023/3/12
 */
@Mapper
public interface ToIndustryScaleInfoVO {

    ToIndustryScaleInfoVO CONVERT = Mappers.getMapper(ToIndustryScaleInfoVO.class);

    /**
     * CountryLogisticsInfo --> IndustryScaleInfoVO
     * @param countryLogisticsInfo CountryLogisticsInfo
     * @return IndustryScaleInfoVO
     */
    IndustryScaleInfoVO toIndustryScaleInfoVO(CountryLogisticsInfo countryLogisticsInfo);

    /**
     * ProvinceLogisticsInfo --> IndustryScaleInfoVO
     * @param provinceLogisticsInfo ProvinceLogisticsInfo
     * @return IndustryScaleInfoVO
     */
    IndustryScaleInfoVO toIndustryScaleInfoVO(ProvinceLogisticsInfo provinceLogisticsInfo);

}
