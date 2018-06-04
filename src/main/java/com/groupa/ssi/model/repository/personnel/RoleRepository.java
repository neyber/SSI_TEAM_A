package com.groupa.ssi.model.repository.personnel;

import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.model.repository.storedprocedures.personnel.RoleRepositoryProcedure;
import com.groupa.ssi.model.repository.storedprocedures.util.RoleProcedures;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lizeth Salazar
 */

public interface RoleRepository extends JpaRepository<Role, Integer>, RoleRepositoryProcedure {
}
