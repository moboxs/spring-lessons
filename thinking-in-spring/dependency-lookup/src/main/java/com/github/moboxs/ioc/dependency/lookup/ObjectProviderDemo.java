package com.github.moboxs.ioc.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过ObjectProvider依赖查找
 */
public class ObjectProviderDemo {  // @Configuration 是非必须的注解

    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为配置类
        applicationContext.register(ObjectProviderDemo.class);
        //启动上下文查找
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupByObjectProvider(applicationContext);

        //关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public String helloWorld() {
        return "hello world";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());

    }
}
