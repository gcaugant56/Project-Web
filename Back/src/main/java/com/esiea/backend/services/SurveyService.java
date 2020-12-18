package com.esiea.backend.services;

import com.esiea.backend.Event;
import com.esiea.backend.Survey;
import com.esiea.backend.Vote;
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
        System.out.println(survey);
        Survey newSurvey = new Survey();
        newSurvey.setVoterChoice(survey.getVoterChoice());
        newSurvey.setVoterEventId(survey.getVoterEventId());
        newSurvey.setVoterName(token);
        Survey getDate = surveyRepository.getSurveyByVoterChoiceAndVoterEventIdAndVoterName(newSurvey.getVoterChoice(), newSurvey.getVoterEventId(), newSurvey.getVoterName());
        if (getDate != null){
           String[] dates = getDate.getVoterChoice().split(",");
            for (String date:dates) {
                if (date.equals(survey.getVoterChoice())){
                    System.out.println("false");
                    return false;
                }
            }

        }

        if (getDate == null) {
            surveyRepository.save(newSurvey);
            return true;
        }
        System.out.println("false");
        return false;
    }

    public List<Vote> getCount(String id)
    {
        System.out.println(id);
        Map<String, Integer> result = new HashMap<String, Integer>();
        Event event = eventService.getEventbyId(Long.parseLong(id));
        System.out.println(event);
        String[] dates = event.getDate().split(",");
        List<Vote> votes = new ArrayList<>();
        for (String date:dates)
        {
            System.out.println(date);
            int count = surveyRepository.findAllByVoterEventIdEqualsAndVoterChoiceContaining(id,date).size();
            System.out.println(count);
            if(count > 0)
            {
                String strcount = String.valueOf(count);
                Vote vote = new Vote(date,strcount);
                votes.add(vote);
            }


        }
        return votes;
    }
}