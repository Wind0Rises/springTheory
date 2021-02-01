package com.liu.study.spring.xiaomage.first.context;

import com.liu.study.spring.xiaomage.first.context.impor.SpecialClassByImport;
import com.liu.study.spring.xiaomage.first.context.impor.SpecialClassByImportResource;
import com.liu.study.spring.xiaomage.first.context.scan.SpecialClassByComponentScan;
import com.liu.study.spring.xiaomage.first.dependency.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/2/1 14:23
 */
@Configuration
@ComponentScan("com.liu.study.spring.xiaomage.first.context.scan")
@PropertySource("classpath:annotation-application-context-test.properties")
@Import({SpecialClassByImport.class})
@ImportResource("classpath:META-INF/annotation-application-context-test.xml")
public class AnnotationApplicationContextTest {
    @Getter
    @Setter
    @Value("${test.couponCode}")
    private String couponCode;

    /**
     * @PropertySource 没有set方法也是可以注入进去的。
     */
    @Getter
    @Value("${test.couponDesc}")
    private String couponDesc;

    @Getter
    @Value("${test.defaultValue:this is default value}")
    private String defaultValue;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 将当前类AnnotationApplicationContextAsIocContainerDemo作为配置类（Configuration Class）
        applicationContext.register(AnnotationApplicationContextTest.class);

        // 刷新操作。
        applicationContext.refresh();

        /**
         * 测试。
         * {@link ConfigurationClassPostProcessor#postProcessBeanDefinitionRegistry}一路跟踪下去。
         */
        componentScanTest(applicationContext);
        propertySourceTest(applicationContext);
        importTest(applicationContext);
        importResourceTest(applicationContext);
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1100L);
        user.setUsername("AnnotationApplicationContext");
        return user;
    }

    /**
     * ComponentScan测试类。
     */
    public static void componentScanTest(AnnotationConfigApplicationContext applicationContext) {
        SpecialClassByComponentScan bean = applicationContext.getBean(SpecialClassByComponentScan.class);
        System.out.println(bean);
    }

    /**
     * PropertySource：测试。
     * <note>
     *      @PropertySource 要配合@Value或@ConfigurationProperties一块使用。这里只测试搭配@Value使用。
     * </note>
     */
    public static void propertySourceTest(AnnotationConfigApplicationContext applicationContext) {
        AnnotationApplicationContextTest bean = applicationContext.getBean(AnnotationApplicationContextTest.class);
        System.out.println(bean.getCouponCode());
        System.out.println(bean.getCouponDesc());
        System.out.println(bean.getDefaultValue());
    }

    /**
     * @Improt 测试。
     */
    public static void importTest(AnnotationConfigApplicationContext applicationContext) {
        SpecialClassByImport bean = applicationContext.getBean(SpecialClassByImport.class);
        System.out.println(bean.getImport());
        System.out.println(bean.getCouponCode());
    }

    /**
     * @ImportResource 测试。
     */
    public static void importResourceTest(AnnotationConfigApplicationContext applicationContext) {
        SpecialClassByImportResource bean = applicationContext.getBean(SpecialClassByImportResource.class);
        System.out.println(bean.getImportResource());
    }

}
