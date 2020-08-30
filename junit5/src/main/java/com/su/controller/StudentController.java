package com.su.controller;

import com.su.bean.Student;
import com.su.config.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author suYan
 * @Date 2020/6/16 0:47
 */
@Slf4j
@RestController
@RequestMapping("/good")
public class StudentController {

    @PostMapping("/students")
    public AjaxResponse saveStudent(@RequestBody Student student) {
        log.info("好学生" + student);
        return AjaxResponse.success(student);
    }
}
