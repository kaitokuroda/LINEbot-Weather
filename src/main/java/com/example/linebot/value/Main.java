package com.example.linebot.value;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Main {
    private final double temp;//気温
    private final double feelslike;//体感温度
    private final double tempMin;//最低気温
    private final double tempMax;//最高気温
    private final double pressure;//気圧
    private final double humidity;//湿度

    @JsonCreator
    public Main(double temp,double feelslike,double tempMin,double tempMax,double pressure,double humidity){
        this.temp=temp;
        this.feelslike=feelslike;
        this.tempMin=tempMin;
        this.tempMax=tempMax;
        this.pressure=pressure;
        this.humidity=humidity;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeelslike() {
        return feelslike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }
}


