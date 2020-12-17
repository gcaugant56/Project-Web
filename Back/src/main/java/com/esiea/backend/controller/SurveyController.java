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
    public boolean createSurvey(@RequestBody Survey survey, @RequestHeader Map<String,String> headers){
        String token = headers.get("authorization");
        System.out.println(token);
        return surveyService.createSurvey(survey,token);
    }

    @GetMapping("/survey/count")
    public Map<String,Integer> getCountVote(@RequestHeader Map<String,String> id){
        Map<String,Integer> result = new HashMap<String, Integer>();
        result = surveyService.getCount(id.get("id"));
        return result;
    }
}