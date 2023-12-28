package com.yhgs.api.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhgs.api.model.Authusers;
import com.yhgs.api.model.UserInfo;
import com.yhgs.api.service.IAuthusersService;
import com.yhgs.api.util.R;
import com.yhgs.api.util.TokenUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
public class AuthusersController {

    @Resource
    private IAuthusersService iAuthusersService;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * app登录接口
     *
     * @return
     */
    @PostMapping(value = "/Ticket")
    public R appLogin(@RequestBody UserInfo userInfo, HttpSession session) {
        Map<String,Object> map = new HashMap<>();
        if (StringUtils.isEmpty(userInfo.getAccountId()) || StringUtils.isEmpty(userInfo.getAccountSecret())) {
            return R.error("输入的用户名或密码或验证码不能为空");
        }
        QueryWrapper<Authusers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("alias", userInfo.getAccountId());
        Authusers authusers =iAuthusersService.getOne(queryWrapper);
        if(userInfo==null){
            return R.error("用户名已经存在");
        }
        if (!userInfo.getAccountSecret().equals(authusers.getLoginpwd())) {
            return R.error("用户名或密码错误");
        }
        Map mapOne = TokenUtil.createToken(authusers);
        map.put("expire_in",mapOne.get("expire_in"));
        map.put("expire_time",mapOne.get("expire_time"));
        redisTemplate.opsForValue().set(mapOne.get("token"), authusers);
        return R.ok(map, (String) mapOne.get("token"));
    }

}
