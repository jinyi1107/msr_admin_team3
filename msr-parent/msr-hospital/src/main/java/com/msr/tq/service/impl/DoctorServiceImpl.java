package com.msr.tq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.tq.entity.Doctor;
import com.msr.tq.mapper.DoctorMapper;
import com.msr.tq.query.DoctorQuery;
import com.msr.tq.service.DoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医生信息表 服务实现类
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

    @Override
    public void pageQuery(Page<Doctor> pageParam, DoctorQuery doctorQuery) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("sort");

        if(doctorQuery == null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return ;
        }

        String dName =doctorQuery.getDName();
        Integer dAge = doctorQuery.getDAge();
        String begin = doctorQuery.getBegin();
        String end = doctorQuery.getEnd();

        if(!StringUtils.isEmpty(dName)){
            queryWrapper.like("dName",dName);
        }

        if (!org.springframework.util.StringUtils.isEmpty(dAge)) {
            queryWrapper.eq("dAge", dAge);
        }

        if(!StringUtils.isEmpty(begin)){
            queryWrapper.ge("gmt_create",begin);
        }

        if(!StringUtils.isEmpty(end)){
            queryWrapper.le("gmt_create",end);

        }

        baseMapper.selectPage(pageParam,queryWrapper);
    }
}
