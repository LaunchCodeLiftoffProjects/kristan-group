package org.launchcode.GardenPlanner.controllers;

import org.launchcode.GardenPlanner.models.PlantType;
import org.launchcode.GardenPlanner.models.PlantTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("plantTypes")
public class PlantTypeController {



    @Autowired
    private PlantTypeRepository plantTypeRepository;

    @GetMapping("")
    public String index (Model model) {

        model.addAttribute("plantTypes", plantTypeRepository.findAll());

        return "plantTypes/index";
    }


    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {


        model.addAttribute(new PlantType());
        return "plantTypes/add";
    }

    //TODO: come back, address model parameter
    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid PlantType newPlantType,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        plantTypeRepository.save(newPlantType);

        return "redirect:";
    }

    @GetMapping("view/{plantTypeId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optPlantType = plantTypeRepository.findById(employerId);
        if (optPlantType.isPresent()) {
            PlantType plantType = (PlantType) optPlantType.get();
            model.addAttribute("plantType", plantType);
            return "plantTypes/view";
        } else {
            return "redirect:../";
        }
    }
}
