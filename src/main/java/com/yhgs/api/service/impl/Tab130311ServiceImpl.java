package com.yhgs.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhgs.api.mapper.Tab130311Mapper;
import com.yhgs.api.model.Tab130311;
import com.yhgs.api.service.ITab130311Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author dell
* @description 针对表【tab130311】的数据库操作Service实现
* @createDate 2023-12-19 09:23:09
*/
@Service
public class Tab130311ServiceImpl extends ServiceImpl<Tab130311Mapper, Tab130311>
    implements ITab130311Service {

    @Resource
    private Tab130311Mapper tab130311Mapper;

    @Override
    public void saveTab130311(Tab130311 tab130311) {
        tab130311Mapper.saveTab130311(tab130311);
    }
}




