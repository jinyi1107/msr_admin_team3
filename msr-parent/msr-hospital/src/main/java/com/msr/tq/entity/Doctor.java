package com.msr.tq.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 医生信息表
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tq_doctor")
@ApiModel(value="Doctor对象", description="医生信息表")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键自增")
    @TableId(value = "d_id", type = IdType.AUTO)
    private Integer dId;

    @ApiModelProperty(value = "医生编号")
    private Integer dNumber;

    @ApiModelProperty(value = "医生姓名")
    private String dName;

    @ApiModelProperty(value = "医生年龄")
    private Integer dAge;

    @ApiModelProperty(value = "医生性别")
    private String dGender;

    @ApiModelProperty(value = "科室表主键")
    private Integer sId;

    @ApiModelProperty(value = "医生职称")
    private String dPosition;

    @ApiModelProperty(value = "医生电话")
    private Integer dPhone;

    @ApiModelProperty(value = "逻辑删除,0为删除，1则否")
    private Integer isDelete;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
