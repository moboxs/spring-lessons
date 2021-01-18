package com.github.moboxs.bean.definition;

import com.github.moboxs.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * 两种方式：
 * 1、通过BeanDefinitionBuilder创建
 * 2、通过AbstractBeanDefinition 抽象
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {
        //1、通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过属性设置
        //beanDefinitionBuilder.addPropertyValue("name", "张三 bean");
        //beanDefinitionBuilder.addPropertyValue("id", 120);
        beanDefinitionBuilder.addPropertyValue("name", "张三 bean")
                .addPropertyValue("id", 120);
        //获取实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //bean definition还可以设置，并非bean最终状态


        //2、通过AbstractBeanDefinition抽象派生构建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置Bean类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过MutablePropertyValue批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        // beanDefinitionBuilder.addPropertyValue("name", "张三 bean")
        //                .addPropertyValue("id", 120);
        propertyValues.add("name", "张三 bean")
                .add("id", 120);
        // 通过set MutablePropertyValue批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
