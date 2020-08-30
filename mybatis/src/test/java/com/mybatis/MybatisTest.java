package com.mybatis;

import com.mybatis.entity.*;
import com.mybatis.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MybatisTest {

    @Resource
    UserMapper userMapper;

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    PlayersMapper playersMapper;

    @Resource
    CourseMapper courseMapper;

    @Resource
    StudentMapper studentMapper;

    // 一对多查询。查询一个用户的同时，把用户关联的购买的多个商品关联出来
    @Test
    void testOneToMore() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    // 一对一查询。查询一个商品关联一个买家用户
    @Test
    void testOneToOne() {
        Goods goods = goodsMapper.selectByPrimaryKey(1);
        System.out.println(goods);
    }

    // 多对一查询。查询多个球员也把关联的球队查询出来
    @Test
    void testMoreToOne() {
      List<Players> players = playersMapper.selectAll();
        System.out.println(players);
    }

    // 多对多查询,由两个互反的一对多关系组成,建立一个中间表
    @Test
    void testMoreTOMore() {
      List<Student> students = studentMapper.selectCourse(1);
        System.out.println(students);
    }
}