package com.groupa.ssi.common.cmd;

import org.springframework.context.ApplicationContext;

/**
 * Factory to instance others commands
 * @author Miguel Rojas
 */
public class CommandFactory {

    private ApplicationContext context;

    public <T extends AbstractCommand> T createInstance(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }
}
