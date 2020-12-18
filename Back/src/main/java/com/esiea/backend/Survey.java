package com.esiea.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "survey")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Survey {
    @Id
    @GeneratedValue
    private long id;
    private String voterName;
    private String voterChoice;
    private String voterEventId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public String getVoterChoice() {
        return voterChoice;
    }

    public void setVoterChoice(String voterChoice) {
        this.voterChoice = voterChoice;
    }

    public String getVoterEventId() {
        return voterEventId;
    }

    public void setVoterEventId(String voterEventId) {
        this.voterEventId = voterEventId;
    }
}
