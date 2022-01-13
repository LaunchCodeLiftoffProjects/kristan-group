package org.launchcode.GardenPlanner.models;


import java.util.ArrayList;

// This is a change made in sandbox.

/**
 * Created by LaunchCode
 */
public class PlantData {


    private static String value;
    private static Iterable<Plant> allPlants;

    /**
     * Returns the results of searching the PlantS data by field and search term.
     *
     * For example, searching for PlantType "Mustard Green" will include results
     * with "Mustard Green".
     *
     * @param column Plant field that should be searched.
     * @param value Value of the field to search for.
     * @param allPlants The list of plantS to search.
     * @return List of all plantS matching the criteria.
     */
    public static ArrayList<Plant> findByColumnAndValue(String column, String value, Iterable<Plant> allPlants) {

        ArrayList<Plant> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Plant>) allPlants;
        }

        if (column.equals("all")){
            results = findByValue(value, allPlants);
            return results;
        }
        for (Plant plant : allPlants) {

            String aValue = getFieldValue(plant, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(plant);
            }
        }

        return results;
    }

    public static String getFieldValue(Plant plant, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = plant.getName();
        } else if (fieldName.equals("plantType")){
            theValue = plant.getPlantType().toString();
        } else {
            theValue = plant.getPlantRequirements().toString();
        }

        return theValue;
    }

    /**
     * Search all Plant fields for the given term.
     *
     * @param value The search term to look for.
     * @param allPlants The list of plantS to search.
     * @return      List of all plantS with at least one field containing the value.
     */
    public static ArrayList<Plant> findByValue(String value, Iterable<Plant> allPlants) {
        PlantData.value = value;
        PlantData.allPlants = allPlants;
        String lower_val = value.toLowerCase();

        ArrayList<Plant> results = new ArrayList<>();

        for (Plant plant : allPlants) {

            if (plant.getName().toLowerCase().contains(lower_val)) {
                results.add(plant);
            } else if (plant.getPlantType().toString().toLowerCase().contains(lower_val)) {
                results.add(plant);
            } else if (plant.getPlantRequirements().toString().toLowerCase().contains(lower_val)) {
                results.add(plant);
            } else if (plant.toString().toLowerCase().contains(lower_val)) {
                results.add(plant);
            }

        }

        return results;
    }


}

