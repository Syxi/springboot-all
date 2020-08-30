package com.mybatis.service;

import com.mybatis.entity.Goods;

public interface GoodsService {
    Goods selectByPrimaryKey(Integer id);
}
