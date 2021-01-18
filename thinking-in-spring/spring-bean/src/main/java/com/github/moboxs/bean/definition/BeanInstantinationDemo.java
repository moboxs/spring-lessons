package com.github.moboxs.bean.definition;

import com.github.moboxs.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean实例化示例
 */
public class BeanInstantinationDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-instantination-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstance = beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(" user=" + user);
        System.out.println(" userByInstance=" + userByInstance);
        System.out.println(" userByFactoryBean=" + userByFactoryBean);



    }
}
