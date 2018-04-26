package com.groupa.ssi.common.cmd;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service to execute the Command and manage the transaction
 * @author Miguel Rojas
 */
@Service
@Transactional
class CommandExecutorService {

    public void execute(AbstractCommand command) {
        command.run();
    }
}
