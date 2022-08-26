package com.bob.bobhr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2022-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bobmanage")
public class Bobmanage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "JobNumber")
    private String JobNumber;

    @TableField("Name")
    private String Name;

    /**
     * 性别
     */
    @TableField("Sex")
    private String Sex;

    @TableField("Age")
    private Integer Age;

    @TableField("CreatTime")
    private LocalDate CreatTime;

    @TableField("LastEdit")
    private LocalDate LastEdit;


}
