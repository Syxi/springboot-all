package com.mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.exception.ResultResponse;
import com.mybatis.entity.Student;
import com.mybatis.service.StudentService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author suYan
 * @Date 2020/5/6 17:05
 */

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    // 查询全部学生
    @GetMapping("/list")
    public List<Student> selectAll() {
        // 设置分页，从第一页开始，每页3条记录
        PageHelper.startPage(1,3);
        return studentService.selectAll();
    }

    // 根据id查询
    @GetMapping("/id")
    public Student selectByPrimaryKey(Integer id) {
        return studentService.selectByPrimaryKey(1);
    }

    // 添加数据  发送Post请求，需要在Postman中测试才可以成功
    @PostMapping("/student")
    public ResultResponse insert() {
        Student student = new Student(4,"苏只", 19, "男");
         studentService.insert(student);
         return ResultResponse.success();
    }

    // 添加数据，只对数据库的指定的列添加数据
    @PostMapping("/selective")
    public ResultResponse insertSelective(Student record) {
        Student student = new Student(4, "苏如");
         studentService.insertSelective(student);
         return ResultResponse.success();
    }

    // 更新数据
    @PutMapping("/update")
    public ResultResponse updateByPrimaryKey(Student recode) {
        Student student = new Student(2,"苏苏",20,"女");
        studentService.updateByPrimaryKey(student);
        return ResultResponse.success();
    }

    // 只更新性别信息
    @PutMapping("/sex")
    public ResultResponse updateSex(Student record) {
        Student student = new Student("女", 1);
        studentService.updateByPrimaryKeySelective(student);
        return ResultResponse.success();
    }

    // 删除数据
    @DeleteMapping("/delete")
    public void delete(Student record) {
        studentService.deleteByPrimaryKey(4);
    }
}
