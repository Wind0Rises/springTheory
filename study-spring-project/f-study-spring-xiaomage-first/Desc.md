# 学习Spring
## 一、Spring的依赖注入、依赖查找。
## 1.1 依赖查找 VS 依赖注入
依赖查找是一种主动获取的模式，实现比较繁琐，代码、业务侵入性较高，依赖容器api，可读性良好。<br>
依赖注入是一种被动接收的模式，实现比较便利，代码、业务侵入性较低，不依赖容器api，可读性一般。
## 1.2 构造器注入 VS Setter注入。

## 1.3 bean的来源
    1、自定义Bean
    2、容器内建Bean对象。
    3、容器内建依赖。
    
## 1.4 Spring IOC配置源信息
    1、Bean定义配置：可以通过xml、Properties、Java注解、Java Api
    2、IoC容器配置：基于XML、基于Java、基于Java API
    3、外部化属性配置：基于Java注解。  
    
## 1.5 BeanFactory和ApplicationContext谁才是Spring IoC容器。
    1、BeanFactory提供了最简单的容器功能，进行管理Bean实例。
    2、ApplicationContext是BeanFactory的子接口：
        1. 简化了和Spring Aop的整合。
        2. 消息和资源的处理。
        3. 事件的发布。
        4. 应用级别的Context，例如WebApplicationContext
        5. 配置的元信息（Configuration Metadata）
        6. 国际化（i18n）
        7. 注解（Annotations）  -->
        8. 资源管理（Resources）
        9. Environment抽象  
        
## 1.6 IoC容器的生命周期。
+ 启动

+ 运行

+ 停止 

## 1.7 面试题
1. BeanFactory和FactoryBean的区别？
   * BeanFactory是IoC底层容器。
   * FactoryBean是创建Bean的一种方式，帮助实现复杂的初始化逻辑。
2. Spring IoC容器启动时做了哪些准备？ 
   * IoC元信息的读取和解析。
   * IoC容器的什么周期。
   * Spring事件发布。
   * 国际化。    
   
   
## 二、Bean Definition（Bean的元信息）
### 2.1 BeanDefinition的元信息包好哪些信息。
   * Class：Bean的全类名。
   * Name：Bean的名称或者ID。
   * Scope：作用域。 singleton、prototype    
   * Constructor Argument：构造器参数，用于依赖注入的。
   * Bean Properties：Bean的属性设置，用于依赖注入。
   * Autowiring mode：Bean自动绑定（通过名称byName、byType）。
   * Lazy Initialization Mode：Bean延迟初始化模式。
   * Initialization Method：Bean初始化回调方法。
   * Destruction Method：Bean销毁的回调方法。  
   
### 2.2 BeanDefinition构造方法
   * 通过BeanDefinitionBuilder。
   * 通过AbstractBeanDefinition以及派生类。