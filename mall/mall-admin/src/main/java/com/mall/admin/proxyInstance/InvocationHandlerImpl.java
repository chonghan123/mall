package com.mall.admin.proxyInstance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hc
 * @classname InvocationHandlerImpl
 * @description TODO
 * @date 2020/3/24
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object subject;

    public InvocationHandlerImpl(Object sunject) {
        this.subject = sunject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前");
        System.out.println(method);
        Object returnValue = method.invoke(subject, args);
        System.out.println("调用之后");
        return returnValue;
    }
}
