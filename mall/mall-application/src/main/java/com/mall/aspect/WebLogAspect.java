package com.mall.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hc
 * @classname requestAspect
 * @description TODO
 * @date 2020/3/24
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
    //@Pointcut("execution(* com.mall.admin.controller.*Controller.*(..))")
    @Around("execution(* com.mall.admin.controller.*Controller.*(..))")
    public void webLog(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        //接口名为方法名
        String interfaceName = joinPoint.getSignature().getName();

        if (ArrayUtils.isNotEmpty(args)) {
            for (Object arg : args) {
                if (!(arg instanceof HttpServletResponse) && !(arg instanceof HttpServletRequest)) {
                    // Debug级别日志
                    log.info("PORTAL|" + interfaceName + ", request = " + JSON.toJSONString(arg));
                }
            }
        }
        Object object = joinPoint.proceed();
        String returnJson = JSON.toJSONString(object);
        log.info("PORTAL|" + interfaceName + ", response = " + returnJson);

    }


}
