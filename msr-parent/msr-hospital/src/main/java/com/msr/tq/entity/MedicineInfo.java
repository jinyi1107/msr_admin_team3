package com.msr.tq.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 药品信息表
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tq_medicine_info")
@ApiModel(value="MedicineInfo对象", description="药品信息表")
public class MedicineInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键自增")
    @TableId(value = "m_id", type = IdType.AUTO)
    private Integer mId;

    @ApiModelProperty(value = "药品名称")
    private String mName;

    @ApiModelProperty(value = "药品规格")
    private String mSpec;

    @ApiModelProperty(value = "药品单价(元)")
    private BigDecimal mPrice;

    @ApiModelProperty(value = "药品功能")
    private String mFunction;

    @ApiModelProperty(value = "生产厂家")
    private String mAddr;

    @ApiModelProperty(value = "有效期")
    private String mTime;

    @ApiModelProperty(value = "库存")
    private Integer mCount;

    @ApiModelProperty(value = "逻辑删除,0为删除，1则否")
    @TableLogic
    @TableField(value = "is_delete")
    private Integer isDelete;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
