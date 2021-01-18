package com.github.moboxs.bean.definition;

import com.github.moboxs.bean.factory.DefaultUserFactory;
import com.github.moboxs.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Bean初始化 示例
 */
@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        //非延迟加载在Spring应用上下文启动完成后，被初始化
        System.out.println("应用上下文已启动....");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);

        System.out.println(userFactory);

        System.out.println("应用上下文准备关闭....");
        applicationContext.close();
        System.out.println("应用上下文正在关闭....");
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    @Lazy(value = false)
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
