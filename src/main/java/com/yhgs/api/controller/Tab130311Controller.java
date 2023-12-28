package com.yhgs.api.controller;

import com.yhgs.api.model.Authusers;
import com.yhgs.api.model.Tab130310;
import com.yhgs.api.model.Tab130311;
import com.yhgs.api.service.ITab130310Service;
import com.yhgs.api.service.ITab130311Service;
import com.yhgs.api.util.R;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisPlusAutoBuilder
 * @since 2023-11-22
 */
@RestController
@RequestMapping("/api")
public class Tab130311Controller {

    @Resource
    private ITab130311Service iTab130311Service;


    @PostMapping(value = "/jyDetailsData")
    public R jyDetailsData(@RequestBody Tab130311 tab130311) {
        System.out.println(tab130311);
        iTab130311Service.saveTab130311(tab130311);
        return R.ok();
    }


}
