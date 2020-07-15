package com.msr.tq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.tq.Query.SectionQuery;
import com.msr.tq.entity.Section;
import com.msr.tq.mapper.SectionMapper;
import com.msr.tq.service.SectionService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 科室表 服务实现类
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Service
public class SectionServiceImpl extends ServiceImpl<SectionMapper, Section> implements SectionService {

    @Override
    public void pageQuery(Page<Section> pageParam, SectionQuery sectionQuery) {
        //条件构造器
        QueryWrapper<Section> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("s_id");//字段不是属性

        if(sectionQuery == null){
            baseMapper.selectPage(pageParam,queryWrapper);
            return;
        }

        Integer sId = sectionQuery.getSId();
        String sName = sectionQuery.getSName();
        String begin = sectionQuery.getBegin();
        String end = sectionQuery.getEnd();

        if(!StringUtils.isEmpty(sId)){
            queryWrapper.like("sid",sId);
        }

        if(!StringUtils.isEmpty(sName)){
            queryWrapper.like("sname",sName);
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
