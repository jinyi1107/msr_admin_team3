package com.msr.tq.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.vo.R;
import com.msr.tq.entity.Notice;
import com.msr.tq.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Api(description="公告信息")
@RestController
@RequestMapping("/tq/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 查询所有公告
     * @return
     */
    @ApiOperation(value = "所有公告")
    @GetMapping("/list")
    public R list(){
        List<Notice> noticeList = noticeService.list(null);
        return R.ok().data("list",noticeList);
    }

    /**
     * 发布新公告
     * @param notice
     * @return
     */
    @ApiOperation(value = "发布新公告")
    @PostMapping
    public R save(
            @ApiParam(name = "notice", value = "公告内容", required = true)
            @RequestBody Notice notice){

        noticeService.save(notice);
        return R.ok();
    }

    /**
     * 根据ID删除公告
     * @param ids
     * @return
     */
    @ApiOperation(value = "根据ID删除公告")
    @DeleteMapping("/delete")  //路径传参    localhost:8080/list/1
    public R removeById(
            @ApiParam(name = "ids", value = "公告ID", required = true)
            @RequestBody Long[] ids){
        boolean flag = noticeService.removeByIds(Arrays.asList(ids));//1
        return R.ok();
    }

    /**
     * 根据id修改公告
     * @param notice
     * @return
     */
    @ApiOperation(value = "根据ID修改公告")
    @PutMapping("/update")
    public R updateById(

            @ApiParam(name = "notice", value = "公告内容", required = true)
            @RequestBody Notice notice){


        noticeService.updateById(notice);
        return R.ok();
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){

        Page<Notice> pageParam = new Page<>(page, limit);

        noticeService.page(pageParam, null);
        List<Notice> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }
}

