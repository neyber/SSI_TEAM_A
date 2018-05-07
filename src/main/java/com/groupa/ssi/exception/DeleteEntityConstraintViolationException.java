/**
 * @author: Miguel Rojas
 */
package com.groupa.ssi.exception;

import com.groupa.ssi.common.exception.DefaultSSIRuntimeException;

public class DeleteEntityConstraintViolationException extends DefaultSSIRuntimeException {

    private Class entityClazz;

    public DeleteEntityConstraintViolationException() {
        super("Can not delete, this entity is referenced");
    }

    public DeleteEntityConstraintViolationException(Class entityClazz) {
        super("Can not delete, this entity is referenced");
        this.entityClazz = entityClazz;
    }

    public Class getEntityClazz() {
        return entityClazz;
    }
}
