package com.journalApplication.ApiResponse;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WeatherResponse {

    public ArrayList<Weather> weather;


    private Main main;

    @Getter
    @Setter
    public class Main{
        private double temp;
        private double feels_like;
    }

    @Getter
    @Setter
    public class Weather{
        private String main;
        private String description;
    }


}
