package com.groupa.ssi.model.repository.storedprocedures.common;

import com.groupa.ssi.model.repository.storedprocedures.util.GenericProcedureNames;

import java.util.List;

/**
 * @author Miguel Rojas
 */
public interface GenericRepositoryProcedure<T, K extends GenericProcedureNames> {

    public List<T> execProcedureFindAll();

    public T execProcedureFindById(Integer id);

    public T execProcedureCreate(T entity);

    public T execProcedureUpdate(T entity);

    public void execProcedureDeleteById(Integer id);

    public K getProcedureNames();

}
