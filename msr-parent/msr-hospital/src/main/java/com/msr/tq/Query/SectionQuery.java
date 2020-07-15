package com.msr.tq.Query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wxy
 * @Package com.msr.tq.Query
 * @date 2020/07/14 11:30
 */
@ApiModel(value = "科室查询对象", description = "科室查询对象封装")
@Data
public class SectionQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "科室编号")
    private Integer sId;

    @ApiModelProperty(value = "科室名称,模糊查询")
    private String sName;

    @ApiModelProperty(value = "查询开始时间", example = "2020-07-09 00:00:00")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2020-12-31 23:59:59")
    private String end;

}
