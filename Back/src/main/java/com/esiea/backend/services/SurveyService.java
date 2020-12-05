package com.esiea.backend.services;

import com.esiea.backend.Survey;
import com.esiea.backend.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    @Autowired
    SurveyRepository surveyRepository;

    public boolean createSurvey(Survey survey){
        surveyRepository.save(survey);
        return true;
    }
}
