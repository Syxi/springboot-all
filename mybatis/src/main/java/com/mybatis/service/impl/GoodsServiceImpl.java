package com.mybatis.service.impl;

import com.mybatis.entity.Goods;
import com.mybatis.mapper.GoodsMapper;
import com.mybatis.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author suYan
 * @Date 2020/5/11 0:23
 */

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public Goods selectByPrimaryKey(Integer id) {
        return goodsMapper.selectByPrimaryKey(1);
    }
}
