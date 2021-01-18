package com.github.moboxs.bean.definition;

import com.github.moboxs.bean.factory.DefaultUserFactory;
import com.github.moboxs.bean.factory.UserFactory;
import com.github.moboxs.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 特殊的Bean实例化 示例
 */
public class SpecialBeanInstantinationDemo {

    public static void main(String[] args) {
        //BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/special-bean-instantination-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/special-bean-instantination-context.xml");
        //通过ApplicationContext获取实现
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        displayServiceLoader(serviceLoader);
        //demoServiceLoader();

        //创建UserFactory对象，通过AutowireCapableBeanFactory实现
        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> userFactories = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        Iterator<UserFactory> it = userFactories.iterator();
        while (it.hasNext()) {
            UserFactory userFactory = it.next();
            System.out.println(userFactory.createUser());
        }
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> it = serviceLoader.iterator();
        while (it.hasNext()) {
            UserFactory userFactory = it.next();
            System.out.println(userFactory.createUser());
        }
    }
}
