package com.zero.logisticsbackend.model.convert;

import com.zero.logisticsbackend.model.po.CountryLogisticsInfo;
import com.zero.logisticsbackend.model.po.ProvinceLogisticsInfo;
import com.zero.logisticsbackend.model.vo.LogisticsIncomeInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * --> LogisticsIncomeInfoVO
 *
 * @author ZERO
 * @date 2023/3/10
 */
@Mapper
public interface ToLogisticsIncomeInfoVO {

    ToLogisticsIncomeInfoVO CONVERT = Mappers.getMapper(ToLogisticsIncomeInfoVO.class);

    /**
     * CountryLogisticsInfo --> LogisticsIncomeInfoVO
     * @param countryLogisticsInfo countryLogisticsInfo
     * @return LogisticsIncomeInfoVO
     */
    LogisticsIncomeInfoVO toLogisticsIncomeInfo(CountryLogisticsInfo countryLogisticsInfo);

    /**
     * ProvinceLogisticsInfo --> LogisticsIncomeInfoVO
     * @param provinceLogisticsInfo provinceLogisticsInfo
     * @return LogisticsIncomeInfoVO
     */
    LogisticsIncomeInfoVO toLogisticsIncomeInfo(ProvinceLogisticsInfo provinceLogisticsInfo);
}
