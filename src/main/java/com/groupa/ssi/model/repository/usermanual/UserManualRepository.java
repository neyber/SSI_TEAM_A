package com.groupa.ssi.model.repository.usermanual;


import com.groupa.ssi.model.domain.usermanual.UserManual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManualRepository extends JpaRepository<UserManual, Integer> {
}
