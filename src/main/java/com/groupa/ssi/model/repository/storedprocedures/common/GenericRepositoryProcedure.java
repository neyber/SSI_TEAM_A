package com.groupa.ssi.model.repository.storedprocedures.common;

import com.groupa.ssi.model.repository.storedprocedures.util.GenericProcedureNames;

import java.util.List;

/**
 * @author Miguel Rojas
 */
public interface GenericRepositoryProcedure<T, K extends GenericProcedureNames> {

    public List<T> execProcedureFindAll(K procedureNames);

    public T execProcedureFindById(Integer id, K procedureNames);

    public void execProcedureCreate(T entity, K procedureNames);

    public void execProcedureUpdate(T entity, K procedureNames);

    public void execProcedureDeleteById(Integer id, K procedureNames);

}
