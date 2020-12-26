package com.liu.study.spring.xiaomage.first.javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link BeanInfo}示例
 *
 * <note>
 *     javaBeans实现IOC容器。
 * </note>
 *
 * @author Liuweian
 * @createTime 2020/12/19 16:17
 * @version 1.0.0
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(item -> {
                    System.out.println(item);

                    Class<?> propertyType = item.getPropertyType();
                    String propertyName = item.getName();

                    if ("age".equals(propertyName)) {
                        item.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                    }

                });
    }


    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }

}
