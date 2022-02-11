package org.launchcode.GardenPlanner.controllers;
import org.launchcode.GardenPlanner.models.Plant;
import org.launchcode.GardenPlanner.models.PlantData;
import org.launchcode.GardenPlanner.models.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import static org.launchcode.GardenPlanner.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private PlantRepository plantRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Plant> plants;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            plants = plantRepository.findAll();
        } else {
            plants = PlantData.findByColumnAndValue(searchType, searchTerm, plantRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Plants with... " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("plants", plants);

        return "search";
    }
}