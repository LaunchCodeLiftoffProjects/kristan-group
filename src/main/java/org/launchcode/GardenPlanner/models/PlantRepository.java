package org.launchcode.GardenPlanner.models;
import org.launchcode.GardenPlanner.models.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Integer> {

}
