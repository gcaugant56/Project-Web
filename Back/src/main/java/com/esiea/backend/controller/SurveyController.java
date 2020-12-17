package com.esiea.backend.controller;

import com.esiea.backend.Survey;
import com.esiea.backend.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class SurveyController {
    @Autowired
    SurveyService surveyService;

    @PostMapping("/survey/create")
    public boolean createSurvey(@RequestBody Survey survey){
        return surveyService.createSurvey(survey);
    }

    @GetMapping("/survey/count")
    public Map<String,Integer> getCountVote(@RequestHeader Map<String,String> id){
        Map<String,Integer> result = new HashMap<String, Integer>();
        System.out.println(id.get("id"));
        result = surveyService.getCount(id.get("id"));
        return result;
    }
}