package com.yhgs.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 易生雄
 * @since 2023-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="DcBasicinfo对象", description="")
public class SssDoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备编号")
    @JsonProperty("MachineId")
    public String MachineId;

    @ApiModelProperty(value = "检测流水号")
    @JsonProperty("SerialNo")
    public String SerialNo;

    @ApiModelProperty(value = "桩号")
    @JsonProperty("PileNo")
    public String PileNo;

    @ApiModelProperty(value = "名称")
    @JsonProperty("CreateName")
    public String CreateName;

    @ApiModelProperty(value = "检测时间")
    @JsonProperty("TestTime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    public Date TestTime;

    @ApiModelProperty(value = "桩长(m)")
    @JsonProperty("PileLength")
    public float PileLength;

    @ApiModelProperty(value = "桩径")
    @JsonProperty("PileDiameter")
    public String PileDiameter;

    @ApiModelProperty(value = "波速（m/s）")
    @JsonProperty("PileVelocity")
    public float PileVelocity;

    @ApiModelProperty(value = "混凝土强度")
    @JsonProperty("ConcreteStrength")
    public String ConcreteStrength;

    @ApiModelProperty(value = "GPS定位信息是否有效")
    @JsonProperty("GpsIsValid")
    public int GpsIsValid;

    @ApiModelProperty(value = "GPS径度（°）")
    @JsonProperty("GpsLongitude")
    public double GpsLongitude;

    @ApiModelProperty(value = "GPS纬度（°）")
    @JsonProperty("GpsLatitude")
    public double GpsLatitude;

    @ApiModelProperty(value = "检测人员上岗证编号")
    @JsonProperty("ShangGangZheng")
    public String ShangGangZheng;


    @ApiModelProperty(value = "是否为高应变测试数据")
    @JsonProperty("IsHighStrainTest")
    public int IsHighStrainTest;

    @ApiModelProperty(value = "（仅高应变适用）测点下桩长（m）")
    @JsonProperty("LengthUnderSensor")
    public float LengthUnderSensor;

    @ApiModelProperty(value = "锤重（kg）")
    @JsonProperty("HammerWeight")
    public float HammerWeight;

    @ApiModelProperty(value = "(高应变适用)锤落距（m）")
    @JsonProperty("HammerDropHeight")
    public float HammerDropHeight;

    @ApiModelProperty(value = "测点截面积（㎡）")
    @JsonProperty("SectionArea")
    public float SectionArea;

    @ApiModelProperty(value = "(仅高应变适用)桩底截面积（㎡）")
    @JsonProperty("BottomArea")
    public float BottomArea;

    @ApiModelProperty(value = "桩密度（kg/m³）")
    @JsonProperty("Density")
    public float Density;

    @ApiModelProperty(value = "(仅高应变适用)测点截面周长（m）")
    @JsonProperty("SectionCircum")
    public float SectionCircum;

    @ApiModelProperty(value = "(仅高应变适用)阻尼系数")
    @JsonProperty("Jc")
    public float Jc;

    @ApiModelProperty(value = "(仅高应变适用)贯入度（mm）")
    @JsonProperty("DepthIn")
    public float DepthIn;

    @ApiModelProperty(value = "(仅高应变适用)测点弹性波速（m/s）")
    @JsonProperty("Vs")
    public float Vs;

    @ApiModelProperty(value = "试验标识")
    @JsonProperty("BaseInfoId")
    public String BaseInfoId;

    @JsonProperty("Channels")
    public ChannelData[] Channels;

    @Data
    public static class ChannelData {

        @JsonProperty("BaseInfoId")
        public String BaseInfoId;

        @JsonProperty("SignalType")
        public byte SignalType ;

        @JsonProperty("SampleInterval")
        public float SampleInterval;

        @JsonProperty("SampleGain")
        public short SampleGain;

        @JsonProperty("SampleLength")
        public short SampleLength;

        @JsonProperty("SensorSensitive")
        public float SensorSensitive;

        @JsonProperty("SampleTime")
        @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
        public Date SampleTime;

        @JsonProperty("FilterFrequency")
        public short FilterFrequency;

        @JsonProperty("ChannelData")
        public short[] ChannelData;

        @JsonProperty("DataVersion")
        public short DataVersion;
    }

}
