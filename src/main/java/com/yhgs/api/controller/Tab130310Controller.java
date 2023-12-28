package com.yhgs.api.controller;

import com.yhgs.api.model.Authusers;
import com.yhgs.api.model.Tab130310;
import com.yhgs.api.service.ITab130310Service;
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
public class Tab130310Controller {

    @Resource
    private ITab130310Service iTab130310Service;

    @Resource
    private RedisTemplate redisTemplate;


    @PostMapping(value = "/jyData")
    public R jyData(@RequestBody Tab130310 tab130310, HttpServletRequest request) {
        Authusers authusers = (Authusers) redisTemplate.opsForValue().get(request.getHeader("Authorization"));
        System.out.println(authusers);
        tab130310.setIsValid(1);
        tab130310.setComId(authusers.getDeptnamecode());
        tab130310.setDwmc(authusers.getDeptname());
        tab130310.setDwbm(authusers.getDeptnamecode());
        System.out.println(tab130310);
        iTab130310Service.saveTab130310(tab130310);
        return R.ok();
    }

}
