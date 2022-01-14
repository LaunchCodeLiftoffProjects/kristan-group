package org.launchcode.GardenPlanner.controllers;

import org.launchcode.GardenPlanner.models.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
// import javax.validation.Valid;
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
