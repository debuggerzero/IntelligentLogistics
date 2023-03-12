package com.zero.logisticsbackend.model.convert;

import com.zero.logisticsbackend.model.po.CountryLogisticsInfo;
import com.zero.logisticsbackend.model.vo.SubareaLogisticsInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * CountryLogisticsInfo --> SubareaLogisticsInfoVO
 *
 * @author ZERO
 * @date 2023/3/12
 */
@Mapper
public interface ToSubareaLogisticsInfoVO {

    ToSubareaLogisticsInfoVO CONVERT = Mappers.getMapper(ToSubareaLogisticsInfoVO.class);

    /**
     * CountryLogisticsInfo --> SubareaLogisticsInfoVO
     * @param countryLogisticsInfo CountryLogisticsInfo
     * @return SubareaLogisticsInfoVO
     */
    @Mappings({
            @Mapping(target = "subareaLogisticsVolume.ELogVolume", source = "ELogVolume"),
            @Mapping(target = "subareaLogisticsVolume.MLogVolume", source = "MLogVolume"),
            @Mapping(target = "subareaLogisticsVolume.WLogVolume", source = "WLogVolume"),
            @Mapping(target = "subareaLogisticsIncome.ELogIncome", source = "ELogIncome"),
            @Mapping(target = "subareaLogisticsIncome.MLogIncome", source = "MLogIncome"),
            @Mapping(target = "subareaLogisticsIncome.WLogIncome", source = "WLogIncome")
    })
    SubareaLogisticsInfoVO toSubareaLogisticsInfoVO(CountryLogisticsInfo countryLogisticsInfo);

}
