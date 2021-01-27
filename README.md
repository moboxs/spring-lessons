# 【Spring核心编程】

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
    1、创建BeanFactory，进行初步初始化，加入内建的bean对象和内建的依赖，或者内建的非bean对象；IoC配置元信息读取和解析，IoC容器生命周期，Spring事件发布，国际化等。
    2、BeanFactory的扩展点  
    3、对Bean的修改  
    
- 运行
    执行容器
    
- 关闭
    applicationContext.close();
    
    
# 一、Spring Bean

## BeanDefinition元信息

~~~~
- Class                        Bean全类名  
- Name                         Bean的名称或ID
- Scope                        Bean的作用域
- Constructor arguments        Bean构造器参数
- Properties                   Bean属性设置
- Autowiring mode              Bean自动绑定模式
- Lazy initialization mode     Bean延迟初始化模式
- Initialization method        Bean初始化回调方法名称
- Destruction method           Bean销毁回调方法名称
~~~~

## 注册Spring Bean
- BeanDefinition注册  
    1、XML配置元信息  
    2、Java注解配置元信息  
        &emsp;&emsp;@Bean  
        &emsp;&emsp;@Component  
        &emsp;&emsp;@Import  
    3、Java API配置元信息  
        &emsp;&emsp;命名方式：BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)   
        &emsp;&emsp;非命名方式： BeanDefinitionReaderUtils.registerWithGeneratedName(AbstractBeanDefinition,BeanDefinitionRegistry);  
        &emsp;&emsp;配置类方式：AnnotatedBeanDefinitionReader#register(Class)

## 实例化Spring Bean
- 常规方式  
    1、通过构造器  
    2、通过静态工厂方法  
    3、通过Bean工厂方法  
    4、通过FactoryBean  
- 特殊方式  
    1、通过ServiceLoaderFactoryBean  
    2、通过AutowireCapableBeanFactory#createBean(java.lang.Class,int,boolean)  
    3、通过BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
    
## 初始化Spring Bean
- @PostConstruct标注方法  
    
- 实现InitializingBean接口的afterPropertiesSet()方法  

- 自定义初始化方法  
1、XML配置：<bean init-method="init" ../>
2、java注解：@Bean(initMethod="init")
3、Java API: AbstractBeanDefinition#setInitMethodName(String)

以上三种方法的执行顺序？  
   @PostConstruct -> InitializingBean#afterPropertiesSet() -> 自定义初始化方法

## 延迟初始化Spring Bean
- XML配置：<bean lazy-init="true" />  
- Java注解：@Lazy(true)  

延迟加载和非延迟加载的区别？  
&emsp;&emsp;非延迟加载在上下文启动前被初始化，延迟加载在上下文启动后初始化

## 销毁Spring Bean
- @PreDestroy标注方法
- 实现DisposableBean接口的destroy()方法
- 自定义销毁方法  
1、XML配置：<bean destroy="destroy" />  
2、Java注解：@Bean(destroy="destroy")  
3、Java API：AbstractBeanDefinition#setDestroyMethodName(String)  

三种销毁方式的执行顺序？
@PreDestroy -> DisposableBean#destroy() ->  自定义销毁方法

## 垃圾回收Spring Bean
- 关闭 Spring容器 （应用上下文）
- 手动执行GC
- Spring Bean 覆盖的finalize()方法被回调


# 二、Spring IoC 依赖查找

## 单一类型依赖查找接口- BeanFactory