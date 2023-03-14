package com.zero.logisticsbackend.model.convert;

import com.zero.logisticsbackend.model.po.ProvinceLogisticsInfo;
import com.zero.logisticsbackend.model.vo.IndustryCycleInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * --> IndustryCycleIndoVO
 *
 * @author ZERO
 * @date 2023/3/14
 */
@Mapper
public interface ToIndustryCycleInfoVO {

    ToIndustryCycleInfoVO CONVERT = Mappers.getMapper(ToIndustryCycleInfoVO.class);

    /**
     * ProvinceLogisticsInfo --> IndustryCycleInfoVO
     * @param provinceLogisticsInfo ProvinceLogisticsInfo
     * @return IndustryCycleInfoVO
     */
    IndustryCycleInfoVO toIndustryCycleInfoVO(ProvinceLogisticsInfo provinceLogisticsInfo);

}
