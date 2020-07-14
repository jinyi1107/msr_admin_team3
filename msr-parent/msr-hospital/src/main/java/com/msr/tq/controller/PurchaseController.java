package com.msr.tq.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.constants.ResultCodeEnum;
import com.msr.common.exception.MSRException;
import com.msr.common.vo.R;
import com.msr.tq.entity.Purchase;
import com.msr.tq.service.PurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 划价表 前端控制器
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Api(description="划价收费")
@RestController
@RequestMapping("/tq/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    /**
     * 获取收费列表
     * @return
     */
    @ApiOperation(value = "收费列表")
    @GetMapping("/list")
    public R list(){
        List<Purchase> purchaseList = purchaseService.list(null);
        return R.ok().data("list", purchaseList);
    }

    /**
     * 添加划价
     * 传递json对象
     * @param purchase
     * @return
     */
    @ApiOperation(value = "添加划价")
    @PostMapping("/save")
    public R save(
            @ApiParam(name = "purchase", value = "划价对象", required = true)
            @RequestBody Purchase purchase){
        purchaseService.save(purchase);
        return R.ok();
    }

    /**
     *分页查询
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "分页收费列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){
        if(page <= 0 || limit <= 0){
            throw new MSRException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<Purchase> pageParam = new Page<>(page, limit);
        purchaseService.page(pageParam, null);
        List<Purchase> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }
}

