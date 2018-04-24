package com.groupa.ssi.exception;

/**
 * @author Miguel Rojas
 */
public class DomainEntityNotFoundException extends RuntimeException {

    private Class entityClazz;

    public DomainEntityNotFoundException(Class entityClazz) {
        super("Entity not found for the given Identifier ");
        this.entityClazz = entityClazz;
    }

    public Class getEntityClazz() {
        return entityClazz;
    }
}
