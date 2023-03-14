package com.zero.logisticsbackend.repo.db;

import com.zero.logisticsbackend.model.po.ProvinceInfo;
import com.zero.logisticsbackend.repo.ProvinceInfoRepo;
import com.zero.logisticsbackend.repo.mapper.ProvinceInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProvinceInfoRepoImpl
 *
 * @author ZERO
 * @date 2023/3/9
 */
@RequiredArgsConstructor
@Repository("provinceInfoRepoImpl")
public class ProvinceInfoRepoImpl implements ProvinceInfoRepo {

    private final ProvinceInfoMapper provinceInfoMapper;

    @Override
    public List<ProvinceInfo> getProvinceInfoList() {
        return provinceInfoMapper.selectList(null);
    }
}
