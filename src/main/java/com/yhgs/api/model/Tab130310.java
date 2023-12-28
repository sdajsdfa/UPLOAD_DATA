package com.yhgs.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tab130310
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("testdata.TAB130310")
public class Tab130310 implements Serializable {
    /**
     * 
     */
    @JsonProperty("StoreId")
    private String StoreId;

    /**
     * 
     */
    @JsonProperty("RelatedDocTypeId")
    private Long RelatedDocTypeId;

    /**
     * 
     */
    @JsonProperty("RelatedDocStoreId")
    private String RelatedDocStoreId;

    /**
     * 
     */
    @JsonProperty("OppTime")
    private Date OppTime;

    /**
     * 单位名称
     */
    @JsonProperty("Dwmc")
    private String Dwmc;

    /**
     * 单位编码
     */
    @JsonProperty("Dwbm")
    private String Dwbm;

    /**
     * 原始数据id
     */
    @JsonProperty("BaseInfoId")
    private String BaseInfoId;

    /**
     * 设备编号
     */
    @JsonProperty("MachineId")
    private String MachineId;

    /**
     * 检测流水号
     */
    @JsonProperty("SerialNo")
    private String SerialNo;

    /**
     * 桩号
     */
    @JsonProperty("PileNo")
    private String PileNo;

    /**
     * 试验方法
     */
    @JsonProperty("TestType")
    private String TestType;

    /**
     * 最大预估荷载(kN)
     */
    @JsonProperty("MaxLoad")
    private Float MaxLoad;

    /**
     * 开始检测的时间
     */
    @JsonProperty("StartTime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date StartTime;

    /**
     * 原始参数
     */
    @JsonProperty("SourceParam")
    private String SourceParam;

    /**
     * 采样次数
     */
    @JsonProperty("RecordCount")
    private int RecordCount;

    /**
     * 定位是否有效
     */
    @JsonProperty("GpsIsValid")
    private int GpsIsValid;

    /**
     * 经度
     */
    @JsonProperty("GpsLongitude")
    private Float GpsLongitude;

    /**
     * 纬度
     */
    @JsonProperty("GpsLatitude")
    private Float GpsLatitude;

    /**
     * 是否正在测试
     */
    @JsonProperty("IsTesting")
    private Object IsTesting;

    /**
     * 当前参数
     */
    @JsonProperty("CurrentParam")
    private String CurrentParam;

    /**
     * 当前读数
     */
    @JsonProperty("CurrentData")
    private String CurrentData;

    /**
     * 上传时间
     */
    @JsonProperty("CreateTime")
    private Date CreateTime;

    /**
     * 最后更新时间
     */
    @JsonProperty("UpdateTime")
    private Date UpdateTime;

    /**
     * 上传设备厂商标识
     */
    @JsonProperty("CreaterName")
    private String CreaterName;

    /**
     * 检测人员上岗证编号
     */
    @JsonProperty("ShangGangZheng")
    private String ShangGangZheng;

    /**
     * 数据有效性
     */
    @JsonProperty("IsValid")
    private int IsValid;

    /**
     * 检测单位编码
     */
    @JsonProperty("ComId")
    private String ComId;

    /**
     * 是否地基试验
     */
    @JsonProperty("IsGroundTest")
    private int IsGroundTest;

    /**
     * 压板面积(㎡)
     */
    @JsonProperty("BoardArea")
    private Float BoardArea;

    /**
     * 上次采样数据荷载方向(加载/卸载)
     */
    @JsonProperty("LastLoadDirect")
    private int LastLoadDirect;

    /**
     * 上次采样数据当前测试级别
     */
    @JsonProperty("LastGrade")
    private int LastGrade;

    /**
     * 上次采样数据的采样次数
     */
    @JsonProperty("LastSampleCount")
    private int LastSampleCount;

    /**
     * 上次采样数据的历时(分钟)
     */
    @JsonProperty("LastTimeCount")
    private int LastTimeCount;

    /**
     * 上次采样数据理论荷载(kN)
     */
    @JsonProperty("LastLoading")
    private Float LastLoading;


    /**
     * 实验状态
     */
    @JsonProperty("TestStatus")
    private String TestStatus;

    /**
     * 数据存储路径
     */
    @JsonProperty("DataUrl")
    private String DataUrl;

}