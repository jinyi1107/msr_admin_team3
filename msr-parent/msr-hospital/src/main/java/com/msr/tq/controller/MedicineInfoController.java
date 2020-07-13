package com.msr.tq.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.constants.ResultCodeEnum;
import com.msr.common.exception.MSRException;
import com.msr.common.vo.R;
import com.msr.tq.entity.MedicineInfo;
import com.msr.tq.service.MedicineInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 药品信息表 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Api(description="药品管理")
@RestController
@RequestMapping("/tq/medicine-info")
public class MedicineInfoController {
    @Autowired
    private MedicineInfoService medicineInfoService;

    /**
     * 获取药品列表
     * @return
     */
    @ApiOperation(value = "药品列表")
    @GetMapping("/list")
    public R list(){
        List<MedicineInfo> medicineList = medicineInfoService.list(null);
        return R.ok().data("list", medicineList);
    }

    /**
     * 删除药品
     * @param ids
     * @return
     */
    @ApiOperation(value = "根据ID删除药品")
    @DeleteMapping("/delete")
    public R removeById(
            @ApiParam(name = "ids", value = "药品ID", required = true)
            @RequestBody Long[] ids){
        boolean flag = medicineInfoService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 新增药品
     * 传递json对象
     * @param medicineInfo
     * @return
     */
    @ApiOperation(value = "新增药品")
    @PostMapping("/save")
    public R save(
            @ApiParam(name = "medicine", value = "药品对象", required = true)
            @RequestBody MedicineInfo medicineInfo){
        medicineInfoService.save(medicineInfo);
        return R.ok();
    }

    /**
     * 修改药品
     * 传递json对象
     * @param medicineInfo
     * @return
     */
    @ApiOperation(value = "根据ID修改药品")
    @PutMapping("/update")
    public R updateById(
            @ApiParam(name = "medicine", value = "药品对象", required = true)
            @RequestBody MedicineInfo medicineInfo){
        medicineInfoService.updateById(medicineInfo);
        return R.ok();
    }

    /**
     * 查询药品
     * 返回json对象
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "药品ID", required = true)
            @PathVariable String id){
        MedicineInfo medicineInfo = medicineInfoService.getById(id);
        return R.ok().data("item", medicineInfo);
    }

    /**
     *分页查询
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "分页药品列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){
        if(page <= 0 || limit <= 0){
            throw new MSRException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<MedicineInfo> pageParam = new Page<>(page, limit);
        medicineInfoService.pageQuery(pageParam, null);
        List<MedicineInfo> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }

}

