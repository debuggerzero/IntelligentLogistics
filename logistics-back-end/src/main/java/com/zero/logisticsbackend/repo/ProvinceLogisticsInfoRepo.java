package com.zero.logisticsbackend.repo;

import com.zero.logisticsbackend.model.po.ProvinceLogisticsInfo;

import java.util.List;

/**
 * ProvinceLogisticsInfoRepo
 *
 * @author ZERO
 * @date 2023/3/13
 */
public interface ProvinceLogisticsInfoRepo {

    /**
     * 查询省物流信息列表
     * @param provinceName 省名
     * @return 省物流信息列表
     */
    List<ProvinceLogisticsInfo> getProvinceLogisticsInfoList(String provinceName);

}
