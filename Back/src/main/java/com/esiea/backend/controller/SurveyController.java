package com.esiea.backend.controller;

import com.esiea.backend.Survey;
import com.esiea.backend.Vote;
import com.esiea.backend.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")

public class SurveyController {
    @Autowired
    SurveyService surveyService;

    @PostMapping("/survey/create")
    public boolean createSurvey(@RequestBody Survey survey, @RequestHeader Map<String,String> headers){
        String token = headers.get("authorization");
        System.out.println(survey);

        return surveyService.createSurvey(survey,token);
    }

    @GetMapping("/survey/count")
    public List<Vote> getCountVote(@RequestHeader Map<String,String> id){
        List<Vote> votes = new ArrayList<>();
        votes= surveyService.getCount(id.get("id"));
        return votes;
    }
}