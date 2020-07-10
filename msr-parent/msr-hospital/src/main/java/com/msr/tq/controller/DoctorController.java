package com.msr.tq.controller;


import com.msr.common.vo.R;
import com.msr.tq.entity.Doctor;
import com.msr.tq.service.DoctorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 医生信息表 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@RestController
@RequestMapping("/tq/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /**
     * 所有医生列表
     */
    @ApiOperation(value = "所有医生列表")
    @GetMapping("/list")
    public R doctorList(){
        List<Doctor> list = doctorService.list(null);
        return R.ok().data("list" , list);
    }
}

