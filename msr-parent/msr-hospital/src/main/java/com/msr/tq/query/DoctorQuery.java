package com.msr.tq.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "Doctor查询对象", description = "医生查询对象封装")
@Data
public class DoctorQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "医生编号")
    private Integer dNumber;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level ;

    @ApiModelProperty(value = "医生姓名")
    private String dName;

    @ApiModelProperty(value = "医生年龄")
    private Integer dAge;

    @ApiModelProperty(value = "医生性别")
    private String dGender;

    @ApiModelProperty(value = "查询时间开始" , example = "2019-01-01 10:10:10")
    private String begin ;

    @ApiModelProperty(value = "查询结束时间" , example = "2019-12-01 10:10:10")
    private String end ;



}
