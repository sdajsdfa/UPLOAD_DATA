package com.yhgs.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PicUploadResult {

   private boolean isLegal;

   private String imgPath;

   private List<String> imgPahts;

}