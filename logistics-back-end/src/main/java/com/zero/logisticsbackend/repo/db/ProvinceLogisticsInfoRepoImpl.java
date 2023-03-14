package com.zero.logisticsbackend.repo.db;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zero.logisticsbackend.exception.AssertionException;
import com.zero.logisticsbackend.model.po.ProvinceInfo;
import com.zero.logisticsbackend.model.po.ProvinceLogisticsInfo;
import com.zero.logisticsbackend.repo.ProvinceLogisticsInfoRepo;
import com.zero.logisticsbackend.repo.mapper.ProvinceInfoMapper;
import com.zero.logisticsbackend.repo.mapper.ProvinceLogisticsInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * ProvinceLogisticsInfoRepoImpl
 *
 * @author ZERO
 * @date 2023/3/13
 */
@RequiredArgsConstructor
@Repository("provinceLogisticsInfoRepoImpl")
public class ProvinceLogisticsInfoRepoImpl implements ProvinceLogisticsInfoRepo {

    private final ProvinceLogisticsInfoMapper provinceLogisticsInfoMapper;

    private final ProvinceInfoMapper provinceInfoMapper;

    @Override
    public List<ProvinceLogisticsInfo> getProvinceLogisticsInfoList(String provinceName) {

        // 获取省信息
        LambdaQueryWrapper<ProvinceInfo> wrapper =
                new LambdaQueryWrapper<ProvinceInfo>().eq(ProvinceInfo::getName, provinceName);
        ProvinceInfo provinceInfo = provinceInfoMapper.selectOne(wrapper);

        if (Objects.isNull(provinceInfo)) {
            throw new AssertionException(500002, "不存在该省名");
        }

        return provinceLogisticsInfoMapper.getProvinceLogisticsInfo(provinceInfo.getId());
    }
}
