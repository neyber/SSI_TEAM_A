package com.groupa.ssi.response.functionmanual;

/**
 * @author Marcelo Loayza
 */

public class FunctionManualResponse {
    private String name;
    private String position;
    private String hierarchicalLever;
    private String superiorBoss;
    private String dependentPersonal;
    private String internalRelation;
    private String externalRelation;
    private String generalActivity;
    private String principalFunction;
    private Integer roleFunction;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() { return position;  }

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

    public String getGeneralActivity() { return generalActivity; }

    public void setGeneralActivity(String generalActivity) { this.generalActivity = generalActivity; }

    public String getPrincipalFunction() { return principalFunction; }

    public void setPrincipalFunction(String principalFunction) { this.principalFunction = principalFunction; }

    public Integer getRoleFunction() { return roleFunction; }

    public void setRoleFunction(Integer roleFunction) { this.roleFunction = roleFunction; }
}
