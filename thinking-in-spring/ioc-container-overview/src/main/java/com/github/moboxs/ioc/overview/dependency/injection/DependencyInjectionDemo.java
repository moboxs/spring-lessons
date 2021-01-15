package com.github.moboxs.ioc.overview.dependency.injection;


import com.github.moboxs.ioc.overview.domain.User;
import com.github.moboxs.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入示例
 *  依赖注入的来源和依赖查找不是一个对象；
 *  依赖来源：
 *  1、自定义bean
 *  2、内部依赖
 *  3、内部容器构建的bean
 *
 *  bean的配置
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        //配置xml文件
        //启动上下文
        //BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        //自定义bean
        UserRepository userRepository = context.getBean("userRepository", UserRepository.class);
        //System.out.println("用户仓库：" + userRepository.getUsers());

        //依赖注入 内部依赖
        //System.out.println(userRepository.getBeanFactory());
        //System.out.println(userRepository.getBeanFactory() == beanFactory);

        //依赖查找(错误)
        //System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory userObjectFactory = userRepository.getObjectFactory();
        System.out.println(userObjectFactory.getObject());

        System.out.println(userObjectFactory.getObject() == context);

        //容器内建 bean
        Environment environment = context.getBean(Environment.class);
        System.out.println(" " + environment);
    }

    private static void whoIsIoCContainer(UserRepository userRepository, ApplicationContext applicationContext) {

        System.out.println(userRepository.getBeanFactory() == applicationContext);

    }

}
