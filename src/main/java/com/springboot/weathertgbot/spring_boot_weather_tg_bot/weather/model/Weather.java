package com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather.model;

import org.json.JSONObject;

import java.math.BigDecimal;

public class Weather {
    BigDecimal temperature;

    public static Weather parseFromJSON(JSONObject jsonObject) {
        BigDecimal temperature = jsonObject.getJSONObject("current").getBigDecimal("temperature_2m");
        return new Weather(temperature);
    }

    public Weather(BigDecimal temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Temperature: " + temperature + "C";
    }
}
