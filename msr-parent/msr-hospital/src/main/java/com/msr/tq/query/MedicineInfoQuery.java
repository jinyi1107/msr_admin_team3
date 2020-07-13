package com.msr.tq.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Gavin
 * @version V1.0
 * @Package com.msr.tq.query
 * @date 2020/7/13 17:31
 * @Copyright © 株式会社多言语系统研究所
 */
@ApiModel(value = "药品查询对象", description = "药品查询对象封装")
@Data
public class MedicineInfoQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师名称,模糊查询")
    private String mName;
}
