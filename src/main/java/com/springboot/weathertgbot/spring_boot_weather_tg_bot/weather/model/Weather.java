package com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather.model;

import java.math.BigDecimal;

public class Weather {

    private BigDecimal temperature;

    public Weather(BigDecimal temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Temperature: " + temperature + "C";
    }
}
