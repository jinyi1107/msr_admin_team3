package com.msr.tq.controller;


import com.msr.common.vo.R;
import com.msr.tq.entity.Section;
import com.msr.tq.service.SectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 科室表 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Api(description="科室管理")
@RestController
@RequestMapping("/tq/section")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @ApiOperation(value = "所有科室列表")
    @GetMapping("/list")
    public R list(){
        List<Section> sectionList = sectionService.list(null);
        return R.ok().data("list",sectionList);
    }

    @ApiOperation(value = "新增科室")
    @PostMapping("/save")
    public R save(
            @ApiParam(name = "section", value = "科室对象", required = true)
            @RequestBody Section section){  //传递的是json对象，@RequestBody把json对象转换为java对象
        sectionService.save(section);
        return R.ok();
    }

    @ApiOperation(value = "根据ID删除科室")
    @DeleteMapping("/delete")  //路径传参    localhost:8080/list/1
    public R removeById(
            @ApiParam(name = "ids", value = "科室ID数组", required = true)
            @RequestBody Long[] ids){
        boolean flag = sectionService.removeByIds(Arrays.asList(ids));//1
        return R.ok();
    }

    @ApiOperation(value = "根据ID修改科室")
    @PutMapping("/update")
    public R updateById(
            @ApiParam(name = "section", value = "科室对象", required = true)
            @RequestBody Section section){

        sectionService.updateById(section);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询科室")
    @GetMapping("/info/{id}") //路径传参
    public R getById(
            @ApiParam(name = "id", value = "科室ID", required = true)
            @PathVariable Integer id){

        Section section = sectionService.getById(id);
        return R.ok().data("item", section);
    }
}

