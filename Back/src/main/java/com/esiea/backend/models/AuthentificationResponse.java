package com.esiea.backend.models;

public class AuthentificationResponse {

    private final String token;

    public AuthentificationResponse(String token) {
        this.token = token;
    }

    public String getToken()
    {
        return this.token;
    }

}
