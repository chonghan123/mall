package com.mall.admin.proxyInstance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author hc
 * @classname ProxyTest
 * @description TODO
 * @date 2020/3/24
 */
public class ProxyTest {


    public static void main(String[] args) {

        SubJect realSubject = new RealSubject();
        InvocationHandler invocationHandler = new InvocationHandlerImpl(realSubject);
        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        SubJect subJect = (SubJect) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        System.out.println(subJect.getClass().getName());
        System.out.println( subJect.sayHello("hc"));
    }
}
