package com.yhgs.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tab130312
 */
@Data
public class Tab130312 implements Serializable {
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
    @JsonProperty("EventTime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date EventTime;

    /**
     * 
     */
    @JsonProperty("EventInfo")
    private String EventInfo;

    /**
     * 
     */
    @JsonProperty("Remark")
    private String Remark;

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

    private static final long serialVersionUID = 1L;
}