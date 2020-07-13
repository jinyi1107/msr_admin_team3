package com.msr.tq.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.tq.entity.MedicineInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.tq.query.MedicineInfoQuery;


/**
 * <p>
 * 药品信息表 服务类
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
public interface MedicineInfoService extends IService<MedicineInfo> {
    void pageQuery(Page<MedicineInfo> pageParam, MedicineInfoQuery medicineInfoQuery);
}
