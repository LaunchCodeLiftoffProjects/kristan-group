package org.launchcode.GardenPlanner.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PlantType extends AbstractEntity {

    //@NotNull
    //@Size(min=3, max = 70, message = "PlantType must be between 3 and 70 characters long.")
    private String GrowingSeason;

    @OneToMany//(mappedBy = "plantType")
    @JoinColumn(name = "plantType_id")
    private final List<Plant> plants = new ArrayList<>();


    public PlantType() {
    }

    public String getGrowingSeason() {
        return GrowingSeason;
    }

    public void setGrowingSeason(String growingSeason) {
        this.GrowingSeason = growingSeason;
    }

    public PlantType(String growingSeason) {
        super();
        this.GrowingSeason = growingSeason;
    }

    public List<Plant> getPlants() {
        return plants;
    }
}
