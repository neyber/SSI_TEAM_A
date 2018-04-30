package com.groupa.ssi.response.catalog;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
public class PpeClassificationResponse {

    private Integer id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
