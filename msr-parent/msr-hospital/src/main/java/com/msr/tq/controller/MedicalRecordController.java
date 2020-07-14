package com.msr.tq.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.vo.R;
import com.msr.tq.entity.MedicalRecord;
import com.msr.tq.service.MedicalRecordService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 病历表 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@RestController
@RequestMapping("/tq/medical-record")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @ApiOperation(value = "所有病例列表")
    @GetMapping("/list")
    public R list(){
        List<MedicalRecord> medicalRecordList = medicalRecordService.list(null);
        return  R.ok().data("list",medicalRecordList);
    }

    @ApiOperation(value = "新增病例")
    @PostMapping("/save")
    public R save(@ApiParam(name="medicalRecord",value="病例",required=true)
                  @RequestBody MedicalRecord medicalRecord){
        medicalRecordService.save(medicalRecord);
        return  R.ok();
    }

    @ApiOperation(value = "根据病例编号删除病例")
    @DeleteMapping("/delete")
    public R removeById(
            @ApiParam(name = "id", value = "病人姓名", required = true)
            @RequestBody Integer id){
            boolean flag = medicalRecordService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "根据病例编号修改病例")
    @PutMapping("/update")
    public R updateById(
        @ApiParam(name = "medicalRecord", value = "病例编号", required = true)
        @RequestBody MedicalRecord medicalRecord){
        medicalRecordService.updateById(medicalRecord);
        return R.ok();
    }

    @ApiOperation(value = "根据病例编号查询病例")
    @GetMapping("/info/{id}")
    public R getById(
            @ApiParam(name = "id", value = "病例编号", required = true)
            @PathVariable Integer id){
        MedicalRecord medicalRecord = medicalRecordService.getById(id);
        return R.ok().data("item",medicalRecord);
    }

    @ApiOperation(value = "分页病例列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){

        Page<MedicalRecord> pageParam = new Page<>(page, limit);

        medicalRecordService.page(pageParam, null);
        List<MedicalRecord> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }









}



