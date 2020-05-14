package com.mall.admin.proxyInstance;

/**
 * @author hc
 * @classname RealSubject
 * @description TODO
 * @date 2020/3/24
 */
public class RealSubject implements SubJect {
    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }

    @Override
    public String sayBye() {
        return "goodBye";
    }
}
