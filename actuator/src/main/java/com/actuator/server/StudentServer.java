package com.actuator.server;

import com.actuator.bean.Student;

public interface StudentServer {

    Student selectById(int id);
}
