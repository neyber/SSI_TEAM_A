package com.groupa.ssi.exception;

import com.groupa.ssi.common.exception.DefaultSSIRuntimeException;

/**
 * @author Miguel Rojas
 */
public class DomainEntityNotFoundException extends DefaultSSIRuntimeException {

    private Class entityClazz;

    public DomainEntityNotFoundException(Class entityClazz) {
        super("Entity not found for the given Identifier ");
        this.entityClazz = entityClazz;
    }

    public Class getEntityClazz() {
        return entityClazz;
    }
}
