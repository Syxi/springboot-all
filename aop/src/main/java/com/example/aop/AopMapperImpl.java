package com.example.aop;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author suYan
 * @Date 2020/8/29 17:55
 */

@Mapper
public class AopMapperImpl implements AopMapper {

    @Autowired
    private AopMapper aopMapper;

    // 保存日记
    @Override
    public void saveLog(Aop aop) {
        aopMapper.saveLog(aop);
    }
}
