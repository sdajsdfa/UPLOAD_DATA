package com.yhgs.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author MybatisPlusAutoBuilder
 * @since 2023-11-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("authusers")
public class Authusers extends Model {

    private static final long serialVersionUID = 1L;

    @TableField("canonical")
    private String canonical;

    @TableField("alias")
    private String alias;

    @TableField("loginpwd")
    private String loginpwd;

    @TableField("deptname")
    private String deptname;

    @TableField("deptnamecode")
    private String deptnamecode;


}
