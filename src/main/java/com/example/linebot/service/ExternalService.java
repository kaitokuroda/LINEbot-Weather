package com.example.linebot.service;

import com.example.linebot.repository.WeatherRepository;
import com.example.linebot.replier.Weather;
import com.example.linebot.value.WeatherItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.linebot.value.WeatherSlot;

@Service
public class ExternalService {
    private final WeatherRepository weatherRepository;

    @Autowired
    public ExternalService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Weather doReplyWithWeather(String text) {
        WeatherSlot weatherSlot=new WeatherSlot(text);
        WeatherItem weatherItem=weatherRepository.findOpenWeatherMap(weatherSlot.getRegion());
        return new Weather(weatherItem);
    }
}
