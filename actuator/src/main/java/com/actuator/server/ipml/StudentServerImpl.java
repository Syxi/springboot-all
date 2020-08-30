package com.actuator.server.ipml;

import com.actuator.bean.Student;
import com.actuator.mapper.StudentMapper;
import com.actuator.server.StudentServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author suYan
 * @Date 2020/7/2 16:55
 */
@Service
public class StudentServerImpl implements StudentServer {
    @Resource
    StudentMapper studentMapper;

    @Override
    public Student selectById(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
