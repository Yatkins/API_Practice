package com.example.final_project.controller;

import com.example.final_project.config.FeatureSwitchMathOnConfig;
import com.example.final_project.model.Person;
import com.example.final_project.model.Values;
import com.example.final_project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")

public class ProjectController {

    private final ProjectService projectService;
    private final FeatureSwitchMathOnConfig featureSwitchMathOnConfig;

    public ProjectController(ProjectService projectService, FeatureSwitchMathOnConfig featureSwitchMathOnConfig) {
        this.projectService = projectService;
        this.featureSwitchMathOnConfig = featureSwitchMathOnConfig;
    }

    @PostMapping("/start")
    public ResponseEntity checkBarMitzvah(@RequestBody Person person) {
        return projectService.checkBarMitzvah(person);
    }

    @GetMapping("/time")
    public ResponseEntity getTime() {
        return projectService.getTime();
    }

    @PostMapping("/{operation}")
    public ResponseEntity doMath( @RequestBody Values values, @PathVariable String operation, @RequestParam(name="v1") double x) {
        if (featureSwitchMathOnConfig.isMathOn()) {
            return projectService.doMath(values, operation, x);
        } else {
            return new ResponseEntity<>("no math allowed here", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}