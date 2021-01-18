package com.github.moboxs.bean.definition;

import com.github.moboxs.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 *  注解 BeanDefinition示例
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)  // 3、通过@Impor进行导入
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Configuration class
        applicationContext.register(Config.class);
        //通过BeanDefinition注册Bean
        // 1、命名Bean的注册方式
        registerBeanDefinition(applicationContext, "zhangsan2-user");
        // 2、非命名bean的注册方式
        registerBeanDefinition(applicationContext);
        //启动应用上下文
        applicationContext.refresh();
        // 1、通过@Bean方式定义
        // 2、通过@Component方式
        // 3、通过@Impor进行导入
        Map<String, Config> configBeans = applicationContext.getBeansOfType(Config.class);
        System.out.println("Config Beans : " + configBeans);
        System.out.println("user Beans : " + applicationContext.getBeansOfType(User.class));


        //显示关闭spring应用上下文
        applicationContext.close();

    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1)
                .addPropertyValue("name", "zhangsan2");
        //判断如果beanName参数存在时，
        if (StringUtils.hasText(beanName)) {
            //注册BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            //非命名方式注册Bean
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry) {
        registerBeanDefinition(registry, null);
    }

    @Component // 2、通过@Component方式
    public static class Config {

        // 1、通过@Bean方式定义
        @Bean( name = {"user", "zhangsan-user"})
        public User user() {
            User user = new User();
            user.setId(100L);
            user.setName("李四");
            return user;
        }
    }

}
