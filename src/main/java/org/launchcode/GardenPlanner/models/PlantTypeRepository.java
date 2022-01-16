package org.launchcode.GardenPlanner.models;
import org.launchcode.GardenPlanner.models.PlantType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantTypeRepository extends CrudRepository<PlantType, Integer>{

}
