package com.example.linebot.value;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WeatherItem {

    private final List<Weather> weather;
    private final Main main;
    private final Wind wind;
    private final String name;

    @JsonCreator
    public WeatherItem(List<Weather> weather,Main main,Wind wind,String name){
        this.weather=weather;
        this.main=main;
        this.wind=wind;
        this.name=name;
    }

    public List<Weather> getWeather(){
        return weather;
    }

    public Main getMain(){
        return main;
    }

    public Wind getWind(){
        return wind;
    }

    public String getName(){
        return name;
    }
}
