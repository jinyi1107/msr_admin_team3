package com.msr.tq.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 病历表
 * </p>
 *
 * @author tom
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tq_medical_record")
@ApiModel(value="MedicalRecord对象", description="病历表")
@Repository
public class MedicalRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键自增")
    @TableId(value = "mr_id", type = IdType.AUTO)
    private Integer mrId;

    @ApiModelProperty(value = "引用挂号信息表主键")
    private Integer rId;

    @ApiModelProperty(value = "诊断结果")
    private String mrMedicalResults;

    @ApiModelProperty(value = "医生建议")
    private String mrDoctorSuggest;

    @ApiModelProperty(value = "诊断时间")
    private Date mrDiagnosisTime;

    @ApiModelProperty(value = "引用下次就诊表主键")
    private Integer nmId;

    @ApiModelProperty(value = "引用划价表主键")
    private Integer puId;


}
