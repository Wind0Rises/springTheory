# Bean Definition内容学习。
## 一、Bean Definition（Bean的元信息）
### 1.1 BeanDefinition的元信息包好哪些信息。
   * Class：Bean的全类名。
   * Name：Bean的名称或者ID。
   * Scope：作用域。 singleton、prototype    
   * Constructor Argument：构造器参数，用于依赖注入的。
   * Bean Properties：Bean的属性设置，用于依赖注入。
   * Autowiring mode：Bean自动绑定（通过名称byName、byType）。
   * Lazy Initialization Mode：Bean延迟初始化模式。
   * Initialization Method：Bean初始化回调方法。
   * Destruction Method：Bean销毁的回调方法。  
   
### 1.2 BeanDefinition构造方法
   * 通过BeanDefinitionBuilder。
   * 通过AbstractBeanDefinition以及派生类。
   
### 1.3 Bean的名称

### 1.4 如何注册Spring Bean
1. XML配置元信息
   * <bean name="....
2. Java注解配置元信息   
   * 通过@Bean方式定义
   * 通过@Component方式
   * 通过@Import来进行导入。
3. Java API配置元信息。
   * org.springframework.beans.factory.support.BeanDefinitionRegistry#registerBeanDefinition(...)
   * org.springframework.beans.factory.support.BeanDefinitionReaderUtils#registerWithGeneratedName(...)
   
### 1.5 实例化Spring Bean
1. 常规的
    * 通过构造器。
    * 通过静态工厂方法
    * 通过Bean工厂方法
    * 通过FactoryBean
2. 特殊的
    * 通过ServiceLoaderFactoryBean
    * 通过AutowireCapableBeanFactory#createBaan(..)
    * 通过BeanDefinitionRegistry#registerBeanDefinition(...)      
    
### 1.6 初始化Spring Bean 
1. PostConstruct标记方法。
2. 实现InitializingBean接口的afterPropertiesSet()方法。
3. 自定义初始化方法
    * XML配置的init-method="指定的方法"
    * Java注解，@Bean(initMethod="指定的方法")
    * Java Api：AbstractBeanDefinition#setInitMethodName("方法名")
    
### 1.7 销毁Spring Bean
1. @PreDestroy标记的方法
2. 实现DisposableBean接口的destroy()方法。
3. 自定义销毁方法
    * XML配置的destroy="指定的方法"
    * Java注解，@Bean(destroy="指定的方法")