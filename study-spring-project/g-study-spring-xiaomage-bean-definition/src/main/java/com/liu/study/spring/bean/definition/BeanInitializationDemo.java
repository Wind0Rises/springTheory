package com.liu.study.spring.bean.definition;

import com.liu.study.spring.bean.definition.factory.DefaultStudentFactory;
import com.liu.study.spring.bean.definition.factory.StudentFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author Liuweian
 * @createTime 2020/12/26 21:20
 * @version 1.0.0
 */
public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();

        applicationContext.close();
    }

    /**
     * 1.先执行无参构造函数
     * 2.再执行被@PostConstruct修饰的方法。
     * 3.然后InitializingBean的afterProperties()方法
     * 3.最后执行自定义初始化方法。
     *
     * @return
     */
    @Bean(initMethod = "customInitMethod")
    public StudentFactory studentFactory() {
        return new DefaultStudentFactory();
    }

}
