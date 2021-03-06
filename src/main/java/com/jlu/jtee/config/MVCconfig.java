package com.jlu.jtee.config;

import com.jlu.jtee.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCconfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("home");
                registry.addViewController("/import.html").setViewName("import");
                registry.addViewController("/photo.html").setViewName("photo");
                registry.addViewController("/admin.html").setViewName("admin");
                registry.addViewController("/manager.html").setViewName("manager");

            }

            @Override
            public void addInterceptors(InterceptorRegistry interceptorRegistry){
                interceptorRegistry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/index.html","/","/Student/login","/asserts/**","/Student/getPhoto",
                                "/Student/getFace","/photo.html","/Student/checkUserName","/Student/signUp","/Student/admin");
            }
        };
        return webMvcConfigurer;
    }
}
