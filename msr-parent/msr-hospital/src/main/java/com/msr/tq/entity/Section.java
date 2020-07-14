package com.msr.tq.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 科室表
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tq_section")
@ApiModel(value="Section对象", description="科室表")
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "科室编号")
    @TableId(value = "s_id", type = IdType.AUTO)
    private Integer sId;

    @ApiModelProperty(value = "科室名称")
    private String sName;

    @ApiModelProperty(value = "科室地址")
    private String sAddr;

    @ApiModelProperty(value = "科室简介")
    private String sInfo;

    @ApiModelProperty(value = "逻辑删除,0为删除，1则否")
    @TableLogic
//    @TableField(value = "is_delete")
    private Integer isDelete;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
