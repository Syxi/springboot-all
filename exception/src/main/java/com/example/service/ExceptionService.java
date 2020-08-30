package com.example.service;

import com.example.exception.CustomException;
import com.example.exception.CustomExceptionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author suYan
 * @Date 2020/7/9 21:43
 */

@Service
public class ExceptionService {

    // 服务层，模拟系统异常
    public void systemBizError() throws CustomException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"在systemBizError方法中，出现ClassNotFoundException");
        }
    }

    // 服务层，模拟用户输入数据导致校验异常
    public List<String> userBizError(int input) throws CustomException {
        if (input < 0) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "你输入的数据不符合逻辑，请重新输入");
        } else {
            List<String> list = new ArrayList<>();
            list.add("小幸运");
            list.add("云烟成雨");
            list.add("夜曲");
            return list;
        }
    }
}
