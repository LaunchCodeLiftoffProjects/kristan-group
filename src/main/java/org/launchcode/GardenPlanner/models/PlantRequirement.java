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

    // @Size(max=500, message = "Description can be as long as necessary ")
    private  String description;
    private String plantingSeason;
    private int plantSize = 0;
    private String sunRequirements;
    private  String Harvesting;

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


    public String getSunRequirements() {
        return sunRequirements;
    }

    public void setSunRequirements(String sunRequirements) {
        this.sunRequirements = sunRequirements;
    }

    public int getPlantSize() {
        return plantSize;
    }

    public void setPlantSize(int plantSize) {
        this.plantSize = plantSize;
    }

    public String getPlantingSeason() {
        return plantingSeason;
    }

    public void setPlantingSeason(String plantingSeason) {
        this.plantingSeason = plantingSeason;
    }

    public String getHarvesting() {
        return Harvesting;
    }

    public void setHarvesting(String harvesting) {
        Harvesting = harvesting;
    }
}

