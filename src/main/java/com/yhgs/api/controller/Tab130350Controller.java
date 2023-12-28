package com.yhgs.api.controller;



import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yhgs.api.model.Authusers;
import com.yhgs.api.model.PicUploadResult;
import com.yhgs.api.model.Tab130350;
import com.yhgs.api.service.ITab130350Service;
import com.yhgs.api.util.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisPlusAutoBuilder
 * @since 2023-11-27
 */
@RestController
@RequestMapping("/api")
public class Tab130350Controller {

    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".png",".gif"};

    @Resource
    private ITab130350Service iTab130350Service;


    @Resource
    private RedisTemplate redisTemplate;


    @PostMapping("/UploadImg")
    public R uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("baseInfoId") String baseInfoId, HttpServletRequest request) {
        Authusers authusers = (Authusers) redisTemplate.opsForValue().get(request.getHeader("Authorization"));
        if(authusers==null){
            return R.error(-1,"Ticket失效");
        }
        Tab130350 tab130350 =new Tab130350();
        boolean isFlag = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
                isFlag = true;
                break;
            }
        }
        if (isFlag) {
            PicUploadResult picUploadResult = iTab130350Service.uplodadImg(file, request);
            boolean isLegal = picUploadResult.isLegal();
            if (isLegal) {
                Map resMap = new HashMap<>();
                resMap.put("imgPath", picUploadResult.getImgPath());
                tab130350.setBaseInfoId(baseInfoId);
                tab130350.setImageUrl(picUploadResult.getImgPath());
                tab130350.setDwmc(authusers.getDeptname());
                tab130350.setDwbm(authusers.getDeptnamecode());
                iTab130350Service.saveTab130350(tab130350);
                return R.ok(resMap);
            } else {
                return R.error(-3,"图片上传有误");
            }
        } else {
            return R.error(-2,"上传的图片格式必须为:bmp,jpg,jpeg,png");
        }
    }
}
