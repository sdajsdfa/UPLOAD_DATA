package com.yhgs.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;


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
@TableName("testdata.TAB130300")
public class Tab130300 extends Model {

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
     * 单位编号
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
     * 桩长(m)
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
     * 波速（m/s）
     */
    @TableField("PILEVELOCITY")
    @JsonProperty("PileVelocity")
    private Float PileVelocity;

    /**
     * 混凝土强度
     */
    @TableField("CONCRETESTRENGTH")
    @JsonProperty("ConcreteStrength")
    private String ConcreteStrength;

    /**
     * GPS定位信息是否有效
     */
    @TableField("GPSISVALID")
    @JsonProperty("GpsIsValid")
    private Long GpsIsValid;

    /**
     * GPS径度
     */
    @TableField("GPSLONGITUDE")
    @JsonProperty("GpsLongitude")
    private Float GpsLongitude;

    /**
     * GPS纬度
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
     * 是否为高应变测试数据
     */
    @TableField("ISHIGHSTRAINTEST")
    @JsonProperty("IsHighStrainTest")
    private Long IsHighStrainTest;

    /**
     * 测点下桩长（m）
     */
    @TableField("LENGTHUNDERSENSOR")
    @JsonProperty("LengthUnderSensor")
    private Float LengthUnderSensor;

    /**
     * 锤重（kg）
     */
    @TableField("HAMMERWEIGHT")
    @JsonProperty("HammerWeight")
    private Float HammerWeight;

    /**
     * 锤落距（m）
     */
    @TableField("HAMMERDROPHEIGHT")
    @JsonProperty("HammerDropHeight")
    private Float HammerDropHeight;

    /**
     * 测点截面积（㎡）
     */
    @TableField("SECTIONAREA")
    @JsonProperty("SectionArea")
    private Float SectionArea;

    /**
     * 桩底截面积（㎡）
     */
    @TableField("BOTTOMAREA")
    @JsonProperty("BottomArea")
    private Float BottomArea;

    /**
     * 桩密度（kg/m3）
     */
    @TableField("DENSITY")
    @JsonProperty("Density")
    private Float Density;

    /**
     * 测点截面周长（m）
     */
    @TableField("SECTIONCIRCUM")
    @JsonProperty("SectionCircum")
    private Float SectionCircum;

    /**
     * 阻尼系数
     */
    @TableField("JC")
    @JsonProperty("Jc")
    private Float Jc;

    /**
     * 贯入度（mm）
     */
    @TableField("DEPTHIN")
    @JsonProperty("DepthIn")
    private Float DepthIn;

    /**
     * 测点弹性波速（m/s）
     */
    @TableField("VS")
    @JsonProperty("Vs")
    private Float Vs;

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
