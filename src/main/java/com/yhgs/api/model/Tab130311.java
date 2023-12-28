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
 * @TableName tab130311
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("testdata.TAB130311")
public class Tab130311 implements Serializable {
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
     * 
     */
    @JsonProperty("BaseInfoId")
    private String BaseInfoId;

    /**
     * 
     */
    @JsonProperty("SampleTime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date SampleTime;

    /**
     * 
     */
    @JsonProperty("LoadDirect")
    private Object LoadDirect;

    /**
     * 
     */
    @JsonProperty("Grade")
    private Object Grade;

    /**
     * 
     */
    @JsonProperty("SampleCount")
    private Object SampleCount;

    /**
     * 
     */
    @JsonProperty("TimeCount")
    private Object TimeCount;

    /**
     * 
     */
    @JsonProperty("Loading")
    private Float Loading;

    /**
     * 
     */
    @JsonProperty("RealLoading")
    private Float RealLoading;

    /**
     * 
     */
    @JsonProperty("RealPress")
    private Float RealPress;

    /**
     * 
     */
    @JsonProperty("S1")
    private Float S1;

    /**
     * 
     */
    @JsonProperty("S2")
    private Float S2;

    /**
     * 
     */
    @JsonProperty("S3")
    private Float S3;

    /**
     * 
     */
    @JsonProperty("S4")
    private Float S4;

    /**
     * 
     */
    @JsonProperty("S5")
    private Float S5;

    /**
     * 
     */
    @JsonProperty("S6")
    private Float S6;

    /**
     * 
     */
    @JsonProperty("S7")
    private Float S7;

    /**
     * 
     */
    @JsonProperty("S8")
    private Float S8;

    /**
     * 
     */
    @JsonProperty("S9")
    private Float S9;

    /**
     * 
     */
    @JsonProperty("S10")
    private Float S10;

    /**
     * 
     */
    @JsonProperty("S11")
    private Float S11;

    /**
     * 
     */
    @JsonProperty("S12")
    private Float S12;

    /**
     * 
     */
    @JsonProperty("SaverAge")
    private Float SaverAge;

    /**
     * 
     */
    @JsonProperty("CreateTime")
    private Date CreateTime;

    /**
     * 
     */
    @JsonProperty("CreaterName")
    private String CreaterName;

    /**
     * 
     */
    @JsonProperty("U1")
    private Float U1;

    /**
     * 
     */
    @JsonProperty("U2")
    private Float U2;

    /**
     * 
     */
    @JsonProperty("U3")
    private Float U3;

    /**
     * 
     */
    @JsonProperty("U4")
    private Float U4;

    /**
     * 
     */
    @JsonProperty("U5")
    private Float U5;

    /**
     * 
     */
    @JsonProperty("U6")
    private Float U6;

    /**
     * 
     */
    @JsonProperty("U7")
    private Float U7;

    /**
     * 
     */
    @JsonProperty("U8")
    private Float U8;

    /**
     * 
     */
    @JsonProperty("U9")
    private Float U9;

    /**
     * 
     */
    @JsonProperty("U10")
    private Float U10;

    /**
     * 
     */
    @JsonProperty("U11")
    private Float U11;

    /**
     * 
     */
    @JsonProperty("U12")
    private Float U12;

    private static final long serialVersionUID = 1L;
}