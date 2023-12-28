package com.yhgs.api.controller;

import com.yhgs.api.model.Tab130312;
import com.yhgs.api.service.ITab130312Service;
import com.yhgs.api.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
public class Tab130312Controller {

    @Resource
    private ITab130312Service iTab130312Service;


    @PostMapping(value = "/jyLogsData")
    public R jyLogsData(@RequestBody Tab130312 tab130312) {
        iTab130312Service.saveTab130312(tab130312);
        return R.ok();
    }


}
