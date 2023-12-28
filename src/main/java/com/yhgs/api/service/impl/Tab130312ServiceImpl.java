package com.yhgs.api.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhgs.api.mapper.Tab130312Mapper;
import com.yhgs.api.model.Tab130312;
import com.yhgs.api.service.ITab130312Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author dell
* @description 针对表【tab130312】的数据库操作Service实现
* @createDate 2023-12-19 09:28:24
*/
@Service
public class Tab130312ServiceImpl extends ServiceImpl<Tab130312Mapper, Tab130312>
        implements ITab130312Service {

    @Resource
    private Tab130312Mapper tab130312Mapper;

    @Override
    public void saveTab130312(Tab130312 tab130312) {
        tab130312Mapper.saveTab130312(tab130312);
    }
}




