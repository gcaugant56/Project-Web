package com.esiea.backend;

public class Vote {
    private String date;
    private String count;

    public Vote(String date, String count)
    {
        this.date=date;
        this.count=count;
    }
    public String getDate() {
        return this.date;
    }
    public String getCount() {
        return this.count;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setCount(String count) {
        this.count = count;
    }


}
