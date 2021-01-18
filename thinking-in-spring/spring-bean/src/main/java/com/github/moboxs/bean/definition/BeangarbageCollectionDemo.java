package com.github.moboxs.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean GC 示例
 */
public class BeangarbageCollectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();
        //关闭应用上下文
        applicationContext.close();
        //强制GC
        System.gc();
    }
}
