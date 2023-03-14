package com.zero.logisticsbackend.repo.mapper;

import com.zero.logisticsbackend.model.po.ProvinceLogisticsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ProvinceLogisticsInfoMapper
 *
 * @author ZERO
 * @date 2023/3/13
 */
@Mapper
public interface ProvinceLogisticsInfoMapper {

    /**
     * getProvinceLogisticsInfo
     * @param proId 省编号
     * @return List<ProvinceLogisticsInfo>
     */
    List<ProvinceLogisticsInfo> getProvinceLogisticsInfo(Integer proId);

}
