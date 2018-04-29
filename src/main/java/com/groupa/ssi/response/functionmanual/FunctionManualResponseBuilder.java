package com.groupa.ssi.response.functionmanual;


//import com.groupa.ssi.model.domain.personnel.Department;

import com.groupa.ssi.model.domain.functionmanual.FunctionManual;

/**
 * @author Marcelo Loayza
 */

public class UserManualResponseBuilder {
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

    private UserManualResponseBuilder() {
    }

    public UserManualResponse build() {
        UserManualResponse userManualResponse = new UserManualResponse();
        userManualResponse.setName(name);
        userManualResponse.setPosition(position);
        userManualResponse.setHierarchicalLever(hierarchicalLever);
        userManualResponse.setSuperiorBoss(superiorBoss);
        userManualResponse.setDependentPersonal(dependentPersonal);
        userManualResponse.setInternalRelation(internalRelation);
        userManualResponse.setExternalRelation(externalRelation);
        userManualResponse.setActivity(activity);
        userManualResponse.setGeneralActivity(generalActivity);
        userManualResponse.setPrincipalFunction(principalFunction);
        return userManualResponse;
    }

    public static UserManualResponseBuilder getInstance(FunctionManual functionManual){
        UserManualResponseBuilder userManualResponseBuilder = new UserManualResponseBuilder();
        userManualResponseBuilder.setName(functionManual.getName());
        userManualResponseBuilder.setPosition(functionManual.getPosition());
        userManualResponseBuilder.setHierarchicalLever(functionManual.getHierarchicalLever());
        userManualResponseBuilder.setSuperiorBoss(functionManual.getSuperiorBoss());
        userManualResponseBuilder.setDependentPersonal(functionManual.getDependentPersonal());
        userManualResponseBuilder.setInternalRelation(functionManual.getInternalRelation());
        userManualResponseBuilder.setExternalRelation(functionManual.getExternalRelation());
        userManualResponseBuilder.setActivity(functionManual.getActivity());
        userManualResponseBuilder.setGeneralActivity(functionManual.getGeneralActivity());
        userManualResponseBuilder.setPrincipalFunction(functionManual.getPrincipalFunction());
        return userManualResponseBuilder;
    }

    public void setName(String name) { this.name = name; }

    public void setPosition(String position) { this.position = position; }

    public void setHierarchicalLever(String hierarchicalLever) { this.hierarchicalLever = hierarchicalLever; }

    public void setSuperiorBoss(String superiorBoss) { this.superiorBoss = superiorBoss; }


    public void setDependentPersonal(String dependentPersonal) { this.dependentPersonal = dependentPersonal; }

    public void setInternalRelation(String internalRelation) { this.internalRelation = internalRelation; }

    public void setExternalRelation(String externalRelation) { this.externalRelation = externalRelation; }

    public void setActivity(String activity) { this.activity = activity; }

    public void setGeneralActivity(String generalActivity) { this.generalActivity = generalActivity; }

    public void setPrincipalFunction(String principalFunction) { this.principalFunction = principalFunction; }
}
