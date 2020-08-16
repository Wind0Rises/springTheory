package com.liu.study.spring.mvc.config;

import com.liu.study.spring.mvc.config.test.Car;
import com.liu.study.spring.mvc.config.test.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configurable与@Component的区别？
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/5 17:46
 */
@Configuration
// @Component
public class CustomConfig {

    @Bean
    public AnnotationBeanInject annotationBeanInject() {
        return new AnnotationBeanInject();
    }


    /**
     * 使用@Configuration注解：代码会像我们期望的一样正常运行，因为driver()这段代码中driver.setCar(car())方法会由Spring代理执行，
     *                       Spring发现方法所请求的Bean已经在容器中，那么就直接返回容器中的Bean。所以全局只有一个Car对象的实例。
     *
     * 使用@Component注解：代码在执行driver() 时driver.setCar(car())不会被Spring代理，会直接调用car()方法获取一个全新的Car对象实例，
     *                       所以全局会有多个Car对象的实例
     *
     */
    @Bean
    public Driver driver() {
        Driver driver = new Driver();
        driver.setId(1);
        driver.setName("driver");
        driver.setCar(car());
        return driver;
    }

    @Bean
    public Car car() {
        Car car = new Car();
        System.out.println("#####################   car：" + car);
        car.setId(1);
        car.setName("car");
        return car;
    }
}