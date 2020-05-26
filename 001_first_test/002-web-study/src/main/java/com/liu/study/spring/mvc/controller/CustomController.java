package com.liu.study.spring.mvc.controller;

import com.liu.study.spring.mvc.controller.vo.SecondTestMethodVo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @desc 
 * @author Liuweian
 * @createTime 2020/5/22 22:08
 * @version 1.0.0
 */
@Controller
@RequestMapping("/spring")
public class CustomController {

    @RequestMapping("/first")
    @ResponseBody
    public String firstController() {
        System.out.println("This is CustomController.firstController Handler Mapping");
        return "success";
    }

    /**
     * RequestMappingHandlerAdapter默认情况是只有下面六个HttpMessageConverter【即只有spring webmvc框架下】。
     *      1、ByteArrayHttpMessageConverter ：application/octet-stream
     *              public boolean supports(Class<?> clazz) {
     * 		            return byte[].class.equals(clazz);
     *              }
     *
     *      2、StringHttpMessageConverter：text/plain； 默认编码格式为：ISO-8859-1。
     *             public boolean supports(Class<?> clazz) {
     * 		            return String.class == clazz;
     *              }
     *
     *      3、ResourceHttpMessageConverter: * /*
     *              protected boolean supports(Class<?> clazz) {
     * 		            return Resource.class.isAssignableFrom(clazz);
     *              }
     *
     *      4、SourceHttpMessageConverter：application/xml、text/xml、application/*+xml
     *              public boolean supports(Class<?> clazz) {
     * 		            return DOMSource.class.equals(clazz) || SAXSource.class.equals(clazz) || StreamSource.class.equals(clazz) || Source.class.equals(clazz);
     *              }
     *
     *      5、AllEncompassingFormHttpMessageConverter：application/x-www-form-urlencoded、multipart/form-data
     *
     *      6、Jaxb2RootElementHttpMessageConverter：也是针对xml。
     *              public boolean canRead(Class<?> clazz, MediaType mediaType) {
     * 		            return (clazz.isAnnotationPresent(XmlRootElement.class) || clazz.isAnnotationPresent(XmlType.class)) && canRead(mediaType);
     *               }
     *
     *      7、MappingJackson2HttpMessageConverter：application/json、application/*+json
     *                  protected boolean supports(Class<?> clazz) {
     * 		                return true;
     *                  }
     * 因为RequestMappingHandlerAdapter中并没有针对application/json的HttpMessageConverter。
     * 所以需要在spring-mvc中配置对应的HttpMessageConverter，这里配置了MappingJackson2HttpMessageConverter。
     * MappingJackson2HttpMessageConverter引用了fastjson相关jar，如果应用了相关jar包，spring mvc也会自动把
     * MappingJackson2HttpMessageConverter添加到RequestMappingHandlerAdapter。不需要再spring-mvc.xml中在配置。
     *
     * 如果不配置application/json对应的HttpMessageConverter，并且以application/json请求，就会包415错误（不支持媒体类型）。
     *
     *
     * 所有你用于接收请求参数的对象和你的Content-Type对应的HttpMessageConverter支持的对象要一致。
     *      例：application/json   ===>       MappingJackson2HttpMessageConverter     ===>    支持所有参数。
     *          text/plain         ===>       StringHttpMessageConverter              ===>    String
     */
    @RequestMapping(value = "/second", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String secondTestMethod(@RequestBody(required = false) SecondTestMethodVo receiveVo) {
        System.out.println(receiveVo.toString());
        return "{\"returnCode\":\"000000\"}";
    }

}
