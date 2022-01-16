package org.launchcode.GardenPlanner.controllers;

import org.launchcode.GardenPlanner.models.Plant;
import org.launchcode.GardenPlanner.models.PlantType;
import org.launchcode.GardenPlanner.models.PlantTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.launchcode.GardenPlanner.models.PlantRepository;

@Controller
@RequestMapping("plants")
public class HomeController {

    @Autowired
    private PlantRepository plantRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "Plants");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Plant");
        model.addAttribute("plants", plantRepository.findAll());
        model.addAttribute(new Plant());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Plant newPlant,
                                    Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }

        Optional<PlantType> optPlantType = PlantTypeRepository.findById(employerId);
        if (optPlantType.isPresent()) {
            PlantType plantType = optPlantType.get();
            newPlant.setPlantType(plantType);
        }

//        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//        newPlant.setSkills(skillObjs);
//        jobRepository.save(newPlant);
//        model.addAttribute("jobs", jobRepository.findAll());
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
