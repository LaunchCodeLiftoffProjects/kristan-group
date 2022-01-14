package org.launchcode.GardenPlanner.models;

import com.sun.istack.NotNull;
import java.util.List;
import javax.persistence.*;


@Entity
public class Plant extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "plant_id")
    //@NotNull(message = "Plant is required")
    private PlantType plantType;

    @ManyToMany
    private List<PlantRequirement> plantRequirements;

    public Plant() {
    }

    public Plant(PlantType anPlantType, List<PlantRequirement> somePlantRequirements) {
        super();
        this.plantType = anPlantType;
        this.plantRequirements = somePlantRequirements;
    }

    // Getters and setters.

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }

    public List<PlantRequirement> getPlantRequirements() {
        return plantRequirements;
    }

    public void setPlantRequirements(List<PlantRequirement> somePlantRequirements) {
        this.plantRequirements = somePlantRequirements;
    }
}

