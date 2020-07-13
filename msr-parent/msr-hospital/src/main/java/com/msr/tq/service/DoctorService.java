package com.msr.tq.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.tq.entity.Doctor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.tq.query.DoctorQuery;

/**
 * <p>
 * 医生信息表 服务类
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
public interface DoctorService extends IService<Doctor> {
    void pageQuery(Page<Doctor> pageParam , DoctorQuery doctorQuery);
}
