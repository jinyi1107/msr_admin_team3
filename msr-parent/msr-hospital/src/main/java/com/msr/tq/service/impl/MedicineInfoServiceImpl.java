package com.msr.tq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.tq.entity.MedicineInfo;
import com.msr.tq.mapper.MedicineInfoMapper;
import com.msr.tq.query.MedicineInfoQuery;
import com.msr.tq.service.MedicineInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 药品信息表 服务实现类
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Service
public class MedicineInfoServiceImpl extends ServiceImpl<MedicineInfoMapper, MedicineInfo> implements MedicineInfoService {

    @Override
    public void pageQuery(Page<MedicineInfo> pageParam, MedicineInfoQuery medicineInfoQuery) {
        QueryWrapper<MedicineInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("m_id");

        if (medicineInfoQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String mName = medicineInfoQuery.getMName();

        if (!StringUtils.isEmpty(mName)) {
            queryWrapper.like("m_name", mName);
        }
    }
}
