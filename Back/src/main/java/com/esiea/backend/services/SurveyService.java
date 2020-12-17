package com.esiea.backend.services;

import com.esiea.backend.Survey;
import com.esiea.backend.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {
    @Autowired
    SurveyRepository surveyRepository;

    public boolean createSurvey(Survey survey){
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
            surveyRepository.save(survey);
            return true;
        }
        return false;
    }
}