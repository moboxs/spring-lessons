# Spring核心编程

https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans

## Spring IoC依赖来源
- 自定义Bean
- 容器内建Bean对象
- 容器内建依赖

## 元信息配置
- Bean 定义配置
    - 基于XML文件
    - 基于Properties文件
    - 基于Java注解
    - 基于Java API
- IoC容器配置
    - 基于XML文件
    - 基于Java注解
    - 基于Java API
- 外部化属性配置
    - 基于Java注解，@Value
    
## Spring上下文
ApplicationContext除了IoC容器角色，还提供：
- 面向切面（AOP）
- 配置元信息（Configuration Metadata）
- 资源管理（Resources）
- 事件（Events）
- 国际化（i18n）
- 注解（Annotation）
- Environment 抽象

BeanFactory是Spring底层IoC容器，ApplicationContext是具备应用特性的BeanFactory超集。


## IoC生命周期
- 启动   
    applicationContext.refresh();  
    1、创建BeanFactory，进行初步初始化，加入内建的bean对象和内建的依赖，或者内建的非bean对象；  
    2、BeanFactory的扩展点  
    3、对Bean的修改  
    
- 运行
    执行容器
    
- 关闭
    applicationContext.close();