package com.journalApplication.Service;


import com.journalApplication.ApiResponse.WeatherResponse;

import com.journalApplication.Cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;



    public WeatherResponse getWeather(String city) {
        String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace("<city name>","mumbai").replace("<API key>",apiKey);
        ResponseEntity<WeatherResponse> response =  restTemplate.exchange(finalApi,HttpMethod.GET,null,WeatherResponse.class);
        WeatherResponse body = response.getBody();
       return body;
    }
}
