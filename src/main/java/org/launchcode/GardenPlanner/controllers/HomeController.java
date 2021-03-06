package org.launchcode.GardenPlanner.controllers;

import org.launchcode.GardenPlanner.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantTypeRepository plantTypeRepository;

    @Autowired
    private PlantRequirementRepository plantRequirementRepository;

//    @GetMapping("")
//    public String addPlantData (Model model, Plant plant) {
//
//        model.addAttribute("plants", plantRepository.findAll());
//
//
//        return "index";
//    }

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "Plants");

        return "index";
    }

    @GetMapping("add")
    public String displayAddPlantForm(Model model) {
        model.addAttribute("title", "Add Plant");
        model.addAttribute("plantTypes", plantTypeRepository.findAll());
        model.addAttribute("PlantRequirement", plantRequirementRepository.findAll());
        model.addAttribute(new Plant());
        return "add";
    }

    @PostMapping("add")
    public String processAddPlantForm(@ModelAttribute @Valid Plant newPlant,
                                    Errors errors, Model model, @RequestParam int plantTypeId, @RequestParam List<Integer> requirements) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        Optional<PlantType> optPlantType = plantTypeRepository.findById(plantTypeId);
        if (optPlantType.isPresent()) {
            PlantType plantType = optPlantType.get();
            newPlant.setPlantType(plantType);
        }

        List<PlantRequirement> reqObjs = (List<PlantRequirement>) plantRequirementRepository.findAllById(requirements);
        newPlant.setPlantRequirements(reqObjs);
        plantRepository.save(newPlant);
        model.addAttribute("plants", plantRepository.findAll());
        return "redirect:";
    }

    @GetMapping("view/{plantId}")
    public String displayViewPlant(Model model, @PathVariable int plantId) {

        Optional optPlant = plantRepository.findById(plantId);
        if (optPlant.isPresent()) {
            Plant plant = (Plant) optPlant.get();
            model.addAttribute("plant", plant);
            return "view";
        } else {
            return "redirect:../";
        }
    }



}
