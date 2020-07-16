package com.msr.tq.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.tq.query.SectionQuery;
import com.msr.tq.entity.Section;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 科室表 服务类
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
public interface SectionService extends IService<Section> {
    /**
     * 分页查询
     * @param pageParam 分页对象
     * @param sectionQuery 查询对象
     */
    void pageQuery(Page<Section> pageParam, SectionQuery sectionQuery);
}
