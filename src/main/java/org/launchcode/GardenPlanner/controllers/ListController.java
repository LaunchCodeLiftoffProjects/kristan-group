package org.launchcode.GardenPlanner.controllers;

import org.launchcode.GardenPlanner.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantTypeRepository plantTypeRepository;

    @Autowired
    private PlantRequirementRepository plantRequirementRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController() {
        columnChoices.put("all", "All");
        columnChoices.put("type", "Type");
        columnChoices.put("requirement", "Requirement");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("plantTypes", plantTypeRepository.findAll());
        model.addAttribute("requirements", plantRequirementRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "plants")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Plant> plants;
        if (column.toLowerCase().equals("all")){
            plants = plantRepository.findAll();
            model.addAttribute("title", "All Plants");
        } else {
            plants = PlantData.findByColumnAndValue(column, value, plantRepository.findAll());
            model.addAttribute("title", "Plants with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("plants", plants);

        return "list-plants";
    }


}
