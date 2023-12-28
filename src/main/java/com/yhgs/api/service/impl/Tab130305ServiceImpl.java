package com.yhgs.api.service.impl;

import com.yhgs.api.mapper.Tab130300Mapper;
import com.yhgs.api.model.Tab130305;
import com.yhgs.api.mapper.Tab130305Mapper;
import com.yhgs.api.service.ITab130305Service;
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
public class Tab130305ServiceImpl extends ServiceImpl<Tab130305Mapper, Tab130305> implements ITab130305Service {

    @Resource
    private  Tab130305Mapper tab130305Mapper;

    @Override
    public void saveTab130305(Tab130305 tab130305) {
        tab130305Mapper.saveTab130305(tab130305);
    }
}
