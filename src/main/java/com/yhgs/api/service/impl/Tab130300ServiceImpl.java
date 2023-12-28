package com.yhgs.api.service.impl;

import com.yhgs.api.mapper.Tab130305Mapper;
import com.yhgs.api.model.Tab130300;
import com.yhgs.api.mapper.Tab130300Mapper;
import com.yhgs.api.model.Tab130305;
import com.yhgs.api.service.ITab130300Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisPlusAutoBuilder
 * @since 2023-11-22
 */
@Service
public class Tab130300ServiceImpl extends ServiceImpl<Tab130300Mapper, Tab130300> implements ITab130300Service {

    @Resource
    private Tab130300Mapper tab130300Mapper;

    @Override
    public void saveTab130300(Tab130300 tab130300) {
        tab130300Mapper.saveTab130300(tab130300);
    }
}
