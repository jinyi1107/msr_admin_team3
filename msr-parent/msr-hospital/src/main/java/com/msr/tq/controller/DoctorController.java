package com.msr.tq.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.constants.ResultCodeEnum;
import com.msr.common.exception.MSRException;
import com.msr.common.vo.R;
import com.msr.tq.entity.Doctor;
import com.msr.tq.query.DoctorQuery;
import com.msr.tq.service.DoctorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @ApiOperation(value = "分页医生列表")
    @GetMapping("/{page}/{limit}")
    public R pageQuery(

            @ApiParam(name= "page" , value = "当前代码" , required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam (name = "doctorQuery" , value = "查询对象" , required = false)


                    DoctorQuery doctorQuery){

        if(page <= 0 || limit <= 0){
            //throw new MSRException(21003, "参数不正确1");
            throw new MSRException(ResultCodeEnum.PARAM_ERROR);
        }

        Page<Doctor> pageParam = new Page<>(page,limit);

        doctorService.pageQuery(pageParam , doctorQuery);
        List<Doctor> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("total" , total).data("rows" , records) ;
    }

}

