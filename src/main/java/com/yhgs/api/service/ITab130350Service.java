package com.yhgs.api.service;

import com.yhgs.api.model.PicUploadResult;
import com.yhgs.api.model.Tab130350;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisPlusAutoBuilder
 * @since 2023-11-27
 */
public interface ITab130350Service extends IService<Tab130350> {

    void saveTab130350(Tab130350 tab130350);

    /**
     * 图片上传
     * @param multipartFile
     * @param request
     * @return
     */
    PicUploadResult uplodadImg(MultipartFile multipartFile, HttpServletRequest request);

}
