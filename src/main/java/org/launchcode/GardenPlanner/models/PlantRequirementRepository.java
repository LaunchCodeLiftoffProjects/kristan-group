package org.launchcode.GardenPlanner.models;
import org.launchcode.GardenPlanner.models.PlantRequirement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRequirementRepository extends CrudRepository<PlantRequirement, Integer> {
}
