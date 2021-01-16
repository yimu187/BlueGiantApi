package com.bluegiant.task.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextHolder {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContextProceted(ApplicationContext applicationContext) throws BeansException {
        if(ApplicationContextHolder.applicationContext == null){
            ApplicationContextHolder.applicationContext = applicationContext;
        }
    }

}
