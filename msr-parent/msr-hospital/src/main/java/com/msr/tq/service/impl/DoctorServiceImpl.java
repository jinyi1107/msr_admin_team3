package com.msr.tq.service.impl;

import com.msr.tq.entity.Doctor;
import com.msr.tq.mapper.DoctorMapper;
import com.msr.tq.service.DoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
