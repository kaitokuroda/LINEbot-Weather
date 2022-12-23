package com.example.linebot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.example.linebot.value.WeatherItem;

@Repository
public class WeatherRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherRepository(RestTemplateBuilder templateBuilder){

        this.restTemplate=templateBuilder.build();
    }

    public WeatherItem findOpenWeatherMap(String region){
        String apikey="12ea4126f7a3ffc4868231078e70e4d6";
        String url=String.format("https://api.openweathermap.org/data/2.5/weather?units=metric&q=%s&APPID=%s&lang=ja",region,apikey);
        return restTemplate.getForObject(url,WeatherItem.class);
    }


}
