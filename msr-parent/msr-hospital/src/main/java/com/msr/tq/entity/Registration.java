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
 * 挂号服务表
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tq_registration")
@ApiModel(value="Registration对象", description="挂号服务表")
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "挂号编号（主键自增）")
    @TableId(value = "r_id", type = IdType.AUTO)
    private Integer rId;

    @ApiModelProperty(value = "病人姓名")
    private String rName;

    @ApiModelProperty(value = "病人年龄")
    private Integer rAge;

    @ApiModelProperty(value = "病人性别")
    private String rGender;

    @ApiModelProperty(value = "病人住址")
    private String rAddr;

    @ApiModelProperty(value = "病人手机")
    private Integer rPhone;

    @ApiModelProperty(value = "引用挂号类型表主键")
    private Integer tId;

    @ApiModelProperty(value = "引用（科室名称）科室表主键")
    private Integer sId;

    @ApiModelProperty(value = "引用主治医生（医生表）主键")
    private Integer dId;

    @ApiModelProperty(value = "引用操作人员表主键")
    private Integer eId;

    @ApiModelProperty(value = "引用病历表主键")
    private Integer mrId;

    @ApiModelProperty(value = "挂号时间")
    private Date rRegistrationTime;

    @ApiModelProperty(value = "就诊时间")
    private Date rTreatmentTime;

    @ApiModelProperty(value = "添加时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
