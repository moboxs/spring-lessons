package com.github.moboxs.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 默认实现
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    //1、基于@PostConstruct注解实现
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct UserFactory 初始化中...");
    }

    @Override
    public void initUserFactory() {
        System.out.println("自定义初始化方法： userFactory初始化中...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean#afterPropertiesSet： userFactory 初始化中...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy UserFactory 销毁中...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean#destroy() 销毁中...");
    }

    @Override
    public void doDestroy() {
        System.out.println("自定义销毁方法，UserFactory 销毁中...");
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("当前DefaultUserFactory对象正在倍垃圾回收...");
    }
}
