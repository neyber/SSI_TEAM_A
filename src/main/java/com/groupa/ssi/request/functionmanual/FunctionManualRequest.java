package com.groupa.ssi.request.functionmanual;

/**
 * @author Marcelo loayza
 */

public class FunctionManualRequest {

    private String name;
    private String position;
    private String hierarchicalLever;
    private String superiorBoss;
    private String dependentPersonal;
    private String internalRelation;
    private String externalRelation;
    private String activity;
    private String generalActivity;
    private String principalFunction;

    public FunctionManualRequest() {
    }


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

    public String getActivity() { return activity; }

    public void setActivity(String activity) { this.activity = activity; }

    public String getGeneralActivity() { return generalActivity; }

    public void setGeneralActivity(String generalActivity) { this.generalActivity = generalActivity; }

    public String getPrincipalFunction() { return principalFunction; }

    public void setPrincipalFunction(String principalFunction) { this.principalFunction = principalFunction; }
}
