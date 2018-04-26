package com.groupa.ssi.common.cmd;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract Command to execute the business logic
 * @author Miguel Rojas
 */
public abstract class AbstractCommand implements Command {
    @Autowired
    private CommandExecutorService service;

    @Override
    public void execute() {
        service.execute(this);
    }

    protected abstract void run();
}
