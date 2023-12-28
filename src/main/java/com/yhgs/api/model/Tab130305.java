package com.yhgs.api.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *
 * </p>
 *
 * @author MybatisPlusAutoBuilder
 * @since 2023-11-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("testdata.TAB130305")
public class Tab130305 extends Model {

    private static final long serialVersionUID = 1L;

    @TableField("STOREID")
    @JsonProperty("StoreId")
    private String StoreId;

    @TableField("RELATEDDOCTYPEID")
    @JsonProperty("RelatedDocTypeId")
    private Long RelatedDocTypeId;

    @TableField("RELATEDDOCSTOREID")
    @JsonProperty("RelatedDocStoreId")
    private String RelatedDocStoreId;

    @TableField("OPPTIME")
    @JsonProperty("OppTime")
    private LocalDateTime OppTime;

    /**
     * 单位名称
     */
    @TableField("DWMC")
    @JsonProperty("Dwmc")
    private String Dwmc;

    /**
     * 单位编码
     */
    @TableField("DWBM")
    @JsonProperty("Dwbm")
    private String Dwbm;

    /**
     * 设备编号
     */
    @TableField("MACHINEID")
    @JsonProperty("MachineId")
    private String MachineId;

    /**
     * 检测流水号
     */
    @TableField("SERIALNO")
    @JsonProperty("SerialNo")
    private String SerialNo;

    /**
     * 桩号
     */
    @TableField("PILENO")
    @JsonProperty("PileNo")
    private String PileNo;

    /**
     * 检测时间
     */
    @TableField("TESTTIME")
    @JsonProperty("TestTime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date TestTime;

    /**
     * 桩长
     */
    @TableField("PILELENGTH")
    @JsonProperty("PileLength")
    private Float PileLength;

    /**
     * 桩径
     */
    @TableField("PILEDIAMETER")
    @JsonProperty("PileDiameter")
    private String PileDiameter;

    /**
     * 混凝土强度
     */
    @TableField("CONCRETESTRENGTH")
    @JsonProperty("ConcreteStrength")
    private String ConcreteStrength;

    /**
     * 声测管数据
     */
    @TableField("TUBECOUNT")
    @JsonProperty("TubeCount")
    private Long TubeCount;

    /**
     * 测试剖面数量
     */
    @TableField("SECTIONCOUNT")
    @JsonProperty("SectionCount")
    private Long SectionCount;

    /**
     * 测试步距（mm）
     */
    @TableField("STEP")
    @JsonProperty("Step")
    private Long Step;

    /**
     * 1号声测管北偏角（°）
     */
    @TableField("ANGLE")
    @JsonProperty("Angle")
    private Long Angle;

    /**
     * GPS定位信息是否有效
     */
    @TableField("GPSISVALID")
    @JsonProperty("GpsIsValid")
    private Long GpsIsValid;

    /**
     * GPS经度（°）
     */
    @TableField("GPSLONGITUDE")
    @JsonProperty("GpsLongitude")
    private Float GpsLongitude;

    /**
     * GPS纬度（°）
     */
    @TableField("GPSLATITUDE")
    @JsonProperty("GpsLatitude")
    private Float GpsLatitude;

    /**
     * 检测人员上岗证编号
     */
    @TableField("SHANGGANGZHENG")
    @JsonProperty("ShangGangZheng")
    private String ShangGangZheng;

    /**
     * 上传时间
     */
    @TableField("CREATETIME")
    @JsonProperty("CreateTime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date CreateTime;

    /**
     * 上传设备厂商标识
     */
    @TableField("CREATENAME")
    @JsonProperty("CreateName")
    private String CreateName;

    /**
     * 试验标识
     */
    @TableField("BASEINFOID")
    @JsonProperty("BaseInfoId")
    private String BaseInfoId;

    /**
     * 数据有效性
     */
    @TableField("ISVALID")
    @JsonProperty("IsValid")
    private Long IsValid;

    /**
     * 检测单位编码
     */
    @TableField("COMID")
    @JsonProperty("ComId")
    private String ComId;

    /**
     * 原始数据url
     */
    @TableField("DATAURL")
    @JsonProperty("DataUrl")
    private String DataUrl;

    /**
     *  压缩文件
     */
    @TableField(exist = false)
    @JsonProperty("ZipFileData")
    private byte[] ZipFileData;


}
