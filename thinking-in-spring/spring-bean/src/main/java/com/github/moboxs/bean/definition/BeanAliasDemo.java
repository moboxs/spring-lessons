package com.github.moboxs.bean.definition;

import com.github.moboxs.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.support.JstlUtils;

/**
 *  Bean 别名示例
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        //配置xml文件
        //启动上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/bean-definition-context.xml");

        //通过别名获取bean
        User user = (User) beanFactory.getBean("user");
        User zhangsanUser = (User) beanFactory.getBean("zhangsan-user");

        if (user.equals(zhangsanUser)) {
            System.out.println("=======" + true);
        }

        System.out.println(" user = " + user);
        System.out.println(" zhangsan user = " + zhangsanUser);



    }
}
