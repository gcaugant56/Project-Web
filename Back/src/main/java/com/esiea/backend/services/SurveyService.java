package com.esiea.backend.services;

import com.esiea.backend.Event;
import com.esiea.backend.Survey;
import com.esiea.backend.repository.SurveyRepository;
import com.esiea.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SurveyService {
    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    EventService eventService;

    @Autowired
    private JwtUtil TokenUtil;

    public boolean createSurvey(Survey survey, String token){

        token = token.substring(7);
        token = TokenUtil.extractUsername(token);

        Survey newSurvey = new Survey();
        newSurvey.setVoterChoice(survey.getVoterChoice());
        newSurvey.setVoterEventId(survey.getVoterEventId());
        newSurvey.setVoterName(token);
        Survey getDate = surveyRepository.getSurveyByVoterChoiceAndVoterEventIdAndVoterName(survey.getVoterChoice(), survey.getVoterEventId(), survey.getVoterName());
        if (getDate != null){
           String[] dates = getDate.getVoterChoice().split(",");
            for (String date:dates) {
                if (date.equals(survey.getVoterChoice())){
                    return false;
                }
            }
        }

        if (getDate == null) {
            surveyRepository.save(newSurvey);
            return true;
        }
        return false;
    }

    public Map<String, Integer> getCount(String id)
    {
        Map<String, Integer> result = new HashMap<String, Integer>();
        Event event = eventService.getEventbyId(Long.parseLong(id));
        System.out.println(event);
        String[] dates = event.getDate().split(",");
        for (String date:dates)
        {
            int count = surveyRepository.countByVoterEventIdAndVoterChoice(id,date);
            result.put(date,count);

        }
        return result;
    }
}