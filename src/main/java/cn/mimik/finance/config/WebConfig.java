package cn.mimik.finance.config;

import cn.mimik.finance.web.filter.DemoFilter;
import cn.mimik.finance.web.listener.DemoListener;
import cn.mimik.finance.web.servlet.DemoServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Created by liugang on 2017/9/13.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FilterRegistrationBean getFilter(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        DemoFilter demoFilter = new DemoFilter();
        registrationBean.setFilter(demoFilter);
        List<String> urlPatterns=new ArrayList<String>();
        urlPatterns.add("/*");//拦截路径，可以添加多个
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean getServlet(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean();
        DemoServlet demoServlet = new DemoServlet();
        registrationBean.setServlet(demoServlet);
        List<String> urlMappings=new ArrayList<String>();
        urlMappings.add("/demoservlet");////访问，可以添加多个
        registrationBean.setUrlMappings(urlMappings);
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<EventListener> getListener(){
        ServletListenerRegistrationBean<EventListener> registrationBean =new ServletListenerRegistrationBean<EventListener>();
        DemoListener demoListener = new DemoListener();
        registrationBean.setListener(demoListener);
        return registrationBean;
    }

}
