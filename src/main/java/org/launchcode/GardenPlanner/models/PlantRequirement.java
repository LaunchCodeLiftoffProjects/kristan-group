package org.launchcode.GardenPlanner.models;


import javax.persistence.Entity;
import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PlantRequirement extends AbstractEntity {

    @ManyToMany(mappedBy = "plantRequirements")
    //@NotNull(message = "plantRequirements is required")
    private final List<Plant> plants = new ArrayList<>();

    //@Size(max=500, message = "Description can be as long as necessary ")
    private  String description;

    public PlantRequirement(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Plant> getPlants() {
        return plants;
    }
}

