package com.msr.tq.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 下次就诊表
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tq_next_medical")
@ApiModel(value="NextMedical对象", description="下次就诊表")
public class NextMedical implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键自增")
    @TableId(value = "nm_id", type = IdType.AUTO)
    private Integer nmId;

    @ApiModelProperty(value = "下一次就诊，1需要，0不需要")
    private Integer nmNextMedical;

    @ApiModelProperty(value = "下一次就诊时间")
    private String nmNextTime;


}
