package com.groupa.ssi.request.personalprotectionequipment;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
public class PpeRequest {

    private String name;
    private String description;
    //private Byte[] image;
    private Integer ppeClassificationId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }*/

    public Integer getPpeClassificationId() {
        return ppeClassificationId;
    }

    public void setPpeClassificationId(int ppeClassificationId) {
        this.ppeClassificationId = ppeClassificationId;
    }
}
