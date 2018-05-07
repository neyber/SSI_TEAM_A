package com.groupa.ssi.response.functionmanual;


import com.groupa.ssi.model.domain.functionmanual.FunctionManual;

/**
 * @author Marcelo Loayza
 */

public class FunctionManualResponseBuilder {
    private Integer id;
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

    private FunctionManualResponseBuilder() {
    }

    public FunctionManualResponse build() {
        FunctionManualResponse functionManualResponse = new FunctionManualResponse();
        functionManualResponse.setId(id);
        functionManualResponse.setName(name);
        functionManualResponse.setPosition(position);
        functionManualResponse.setHierarchicalLever(hierarchicalLever);
        functionManualResponse.setSuperiorBoss(superiorBoss);
        functionManualResponse.setDependentPersonal(dependentPersonal);
        functionManualResponse.setInternalRelation(internalRelation);
        functionManualResponse.setExternalRelation(externalRelation);
        functionManualResponse.setGeneralActivity(generalActivity);
        functionManualResponse.setPrincipalFunction(principalFunction);
        functionManualResponse.setRoleFunction(roleFunction);

        return functionManualResponse;
    }

    public static FunctionManualResponseBuilder getInstance(FunctionManual functionManual){

        FunctionManualResponseBuilder functionManualResponseBuilder = new FunctionManualResponseBuilder();
        functionManualResponseBuilder.setId(functionManual.getId());
        functionManualResponseBuilder.setName(functionManual.getName());
        functionManualResponseBuilder.setPosition(functionManual.getPosition());
        functionManualResponseBuilder.setHierarchicalLever(functionManual.getHierarchicalLever());
        functionManualResponseBuilder.setSuperiorBoss(functionManual.getSuperiorBoss());
        functionManualResponseBuilder.setDependentPersonal(functionManual.getDependentPersonal());
        functionManualResponseBuilder.setInternalRelation(functionManual.getInternalRelation());
        functionManualResponseBuilder.setExternalRelation(functionManual.getExternalRelation());
        functionManualResponseBuilder.setGeneralActivity(functionManual.getGeneralActivity());
        functionManualResponseBuilder.setPrincipalFunction(functionManual.getPrincipalFunction());
        functionManualResponseBuilder.setRoleFunction(functionManual.getRoleFunction().getId());
        return functionManualResponseBuilder;
    }

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setPosition(String position) { this.position = position; }

    public void setHierarchicalLever(String hierarchicalLever) { this.hierarchicalLever = hierarchicalLever; }

    public void setSuperiorBoss(String superiorBoss) { this.superiorBoss = superiorBoss; }

    public void setDependentPersonal(String dependentPersonal) { this.dependentPersonal = dependentPersonal; }

    public void setInternalRelation(String internalRelation) { this.internalRelation = internalRelation; }

    public void setExternalRelation(String externalRelation) { this.externalRelation = externalRelation; }

    public void setGeneralActivity(String generalActivity) { this.generalActivity = generalActivity; }

    public void setPrincipalFunction(String principalFunction) { this.principalFunction = principalFunction; }

    public void setRoleFunction(Integer roleFunction) { this.roleFunction = roleFunction; }


}
