package com.groupa.ssi.model.domain.functionmanual;

import com.groupa.ssi.model.domain.ModelBase;
import com.groupa.ssi.model.domain.personnel.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Marcelo Loayza
 */

@Entity
public class FunctionManual extends ModelBase {

    @Column
    private String name;
    @Column
    private String position;
    @Column
    private String hierarchicalLever;
    @Column
    private String superiorBoss;
    @Column
    private String dependentPersonal;
    @Column
    private String internalRelation;
    @Column
    private String externalRelation;
    @Column
    private String activity;
    @Column
    private String generalActivity;
    @Column
    private String principalFunction;
    @OneToOne
    private Role roleFunction;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public String getHierarchicalLever() { return hierarchicalLever; }

    public void setHierarchicalLever(String hierarchicalLever) { this.hierarchicalLever = hierarchicalLever; }

    public String getSuperiorBoss() { return superiorBoss; }

    public void setSuperiorBoss(String superiorBoss) { this.superiorBoss = superiorBoss; }

    public String getDependentPersonal() { return dependentPersonal; }

    public void setDependentPersonal(String dependentPersonal) { this.dependentPersonal = dependentPersonal; }

    public String getInternalRelation() { return internalRelation; }

    public void setInternalRelation(String internalRelation) { this.internalRelation = internalRelation; }

    public String getExternalRelation() { return externalRelation; }

    public void setExternalRelation(String externalRelation) { this.externalRelation = externalRelation; }

    public String getActivity() { return activity; }

    public void setActivity(String activity) { this.activity = activity; }

    public String getGeneralActivity() { return generalActivity; }

    public void setGeneralActivity(String generalActivity) { this.generalActivity = generalActivity; }

    public String getPrincipalFunction() { return principalFunction; }

    public void setPrincipalFunction(String principalFunction) { this.principalFunction = principalFunction; }

    public Role getRoleFunction() { return roleFunction; }

    public void setRoleFunction(Role roleFunction) { this.roleFunction = roleFunction; }
}
