package com.yhgs.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
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
 * @since 2023-11-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("testdata.AB130350")
public class Tab130350 extends Model {

    private static final long serialVersionUID = 1L;

    @TableField("STOREID")
    private String StoreId;

    @TableField("RELATEDDOCTYPEID")
    private Long RelatedDocTypeId;

    @TableField("RELATEDDOCSTOREID")
    private String RelatedDocStoreId;

    @TableField("OPPTIME")
    private LocalDateTime OppTime;

    /**
     * 单位名称
     */
    @TableField("DWMC")
    private String Dwmc;

    /**
     * 单位编码
     */
    @TableField("DWBM")
    private String Dwbm;

    /**
     * 关联的数据主键 
     */
    @TableField("BASEINFOID")
    private String BaseInfoId;

    /**
     * 图片地址
     */
    @TableField("IMAGEURL")
    private String ImageUrl;


}
