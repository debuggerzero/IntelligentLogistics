package com.zero.logisticsbackend.repo;

import com.zero.logisticsbackend.model.po.ProvinceInfo;

import java.util.List;

/**
 * ProvinceInfoRepo
 *
 * @author ZERO
 * @date 2023/3/9
 */
public interface ProvinceInfoRepo {

    /**
     * 获取省份列表
     * @return 集合
     */
    List<ProvinceInfo> getProvinceInfoList();

}
