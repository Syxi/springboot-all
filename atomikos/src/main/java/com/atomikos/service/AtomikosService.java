package com.atomikos.service;

import com.atomikos.mapper.primarydb.Article;
import com.atomikos.mapper.secondarydb.Message;
import com.atomikos.mapper.primarydb.ArticleMapper;
import com.atomikos.mapper.secondarydb.MessageMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author suYan
 * @Date 2020/8/3 22:23
 */

@Service
public class AtomikosService {
    @Resource
    ArticleMapper articleMapper;
    @Resource
    MessageMapper messageMapper;

    @Transactional
    public void addArticle() {
        articleMapper.insertSelective(new Article(1, "苏彦","分布式", "atomikos实现"));
    }

    @Transactional
    public void addMessage() {
        messageMapper.insertSelective(new Message(1, "atomikos", "多数据源"));
        // 故意设置异常，回滚事务
        int a = 2/0;
    }
}
