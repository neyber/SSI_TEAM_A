/**
 * @author: Miguel Rojas
 */
package com.groupa.ssi.exception;

import com.groupa.ssi.common.exception.DefaultSSIRuntimeException;

public class DeleteEntityNotFoundException extends DefaultSSIRuntimeException {

    private Class entityClazz;

    public DeleteEntityNotFoundException(Class entityClazz) {
        super("Can not delete, entity not found");
        this.entityClazz = entityClazz;
    }

    public Class getEntityClazz() {
        return entityClazz;
    }
}
