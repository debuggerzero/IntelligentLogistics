package com.zero.logisticsbackend.repo;

import com.zero.logisticsbackend.model.po.CountryLogisticsInfo;

import java.util.List;

/**
 * CountryLogisticsInfoRepo
 *
 * @author ZERO
 * @date 2023/3/9
 */
public interface CountryLogisticsInfoRepo {

    /**
     * 获取国家物流数据信息
     * @return 集合
     */
    List<CountryLogisticsInfo> getCountryLogisticsInfoList();

}
