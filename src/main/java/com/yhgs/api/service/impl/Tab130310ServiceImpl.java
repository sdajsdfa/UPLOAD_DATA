package com.yhgs.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhgs.api.mapper.Tab130310Mapper;
import com.yhgs.api.model.Tab130310;
import com.yhgs.api.service.ITab130310Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author dell
* @description 针对表【tab130310】的数据库操作Service实现
* @createDate 2023-12-18 15:20:47
*/
@Service
public class Tab130310ServiceImpl extends ServiceImpl<Tab130310Mapper, Tab130310> implements ITab130310Service {

    @Resource
    private Tab130310Mapper tab130310Mapper;

    @Override
    public void saveTab130310(Tab130310 tab130310) {
        tab130310Mapper.saveTab130310(tab130310);
    }
}




