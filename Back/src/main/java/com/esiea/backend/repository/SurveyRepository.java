package com.esiea.backend.repository;

import com.esiea.backend.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    Survey getSurveyByVoterChoiceAndVoterEventIdAndVoterName(String date, String id, String name);
    List<Survey> findAllByVoterEventIdContainingAndVoterChoiceContaining(String id, String date);
}
