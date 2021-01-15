package com.github.moboxs.ioc.overview.dependency.lookup;


import com.github.moboxs.ioc.overview.annotation.Supper;
import com.github.moboxs.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找三种方式：
 * 1、通过名称查找
 * 2、通过类型查找
 * 3、通过注解查找
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        //配置xml文件
        //启动上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupInRealtime(beanFactory);
        lookupInLazy(beanFactory);
        //按照类型查找
        lookupByType(beanFactory);
        //按照类型查找 结合对象
        lookupByCollectionType(beanFactory);

        //通过注解查找
        lookupByAnnotition(beanFactory);
    }

    private static void lookupByAnnotition(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> users = listableBeanFactory.getBeansWithAnnotation(Supper.class);
            System.out.println("查找标注 @Supper 的集合对象" + users);

        }
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有集合对象：" + users);

        }
    }

    private static void lookupInRealtime (BeanFactory beanFactory) {
        User user = (User)beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }


    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据类型 实时查找：" + user);
    }
}
