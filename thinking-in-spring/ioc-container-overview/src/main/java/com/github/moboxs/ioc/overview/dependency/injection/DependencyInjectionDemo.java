package com.github.moboxs.ioc.overview.dependency.injection;


import com.github.moboxs.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 *
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        //配置xml文件
        //启动上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        //System.out.println("用户仓库：" + userRepository.getUsers());

        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        System.out.println();

        

    }

}
