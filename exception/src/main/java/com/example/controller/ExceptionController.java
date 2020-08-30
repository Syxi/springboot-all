package com.example.controller;

import com.example.bean.Article;
import com.example.exception.ResultBean;
import com.example.service.ExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author suYan
 * @Date 2020/7/9 23:02
 */

@RestController
@Slf4j
public class ExceptionController {
    @Resource
    ExceptionService exceptionService;

    @RequestMapping("/add")
    public Article add() {
        Article article = Article.builder()
                .id(1)
                .author("苏彦")
                .build();
        log.info("测试：" + article);
        return article;
    }


    @RequestMapping("/e/system")
    public @ResponseBody ResultBean system() {
        exceptionService.systemBizError();
        return ResultBean.success();
    }

    @RequestMapping("/e/user")
    public @ResponseBody ResultBean user(Integer input) {
        return ResultBean.success(exceptionService.userBizError(input));
    }
}
