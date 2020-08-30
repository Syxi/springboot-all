package com.example.aop;


import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.example.annotation.Log;
import com.example.util.HttpContextUtil;
import com.example.util.IPUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import javax.annotation.Resource;

/**
 * @Author suYan
 * @Date 2020/8/29 18:21
 * 切面类LogAspect 对AopDao的 savelog()方法增强
 */

@Configuration
@EnableAspectJAutoProxy
@Aspect
public class LogAspect {

    @Resource
    private AopMapper aopMapper;

    // 切入点
    @Pointcut("@annotation(com.example.annotation.Log)")
    public void pointCut() {} // 方法名随意

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        Long beginTime = System.currentTimeMillis();
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long time = System.currentTimeMillis() - beginTime;
        // 保存日记
        saveLog(point, time);
        return  result;
    }


    private void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Aop aop = new Aop();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            aop.setOperation(logAnnotation.value());
        }
        // 请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        aop.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = point.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            aop.setParams(params);
        }
        // 获取request
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        // 设置IP地址
        aop.setIp(IPUtil.getIpAddr(request));
        // 模拟一个用户名
        aop.setUserName("suYan");
        aop.setTime((int) time);
        aop.setCreateTime(new Date());
        // 保存系统日志
        aopMapper.saveLog(aop);
    }

}
