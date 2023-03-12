package com.zero.logisticsbackend.repo.db;

import com.zero.logisticsbackend.model.po.CountryLogisticsInfo;
import com.zero.logisticsbackend.repo.CountryLogisticsInfoRepo;
import com.zero.logisticsbackend.repo.mapper.CountryLogisticsInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CountryLogisticsInfoRepoImpl
 *
 * @author ZERO
 * @date 2023/3/9
 */
@RequiredArgsConstructor
@Repository("countryLogisticsInfoRepoImpl")
public class CountryLogisticsInfoRepoImpl implements CountryLogisticsInfoRepo {

    private final CountryLogisticsInfoMapper countryLogisticsInfoMapper;

    @Override
    public List<CountryLogisticsInfo> getCountryLogisticsInfoList() {
        return countryLogisticsInfoMapper.selectList(null);
    }
}
