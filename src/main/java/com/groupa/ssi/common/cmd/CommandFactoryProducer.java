package com.groupa.ssi.common.cmd;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Miguel Rojas
 */
@Component
public class CommandFactoryProducer implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    @Scope("prototype")
    public CommandFactory commandFactory() {
        CommandFactory instance = new CommandFactory();
        instance.setApplicationContext(applicationContext);
        return instance;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
