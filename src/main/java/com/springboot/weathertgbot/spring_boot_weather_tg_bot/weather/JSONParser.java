package com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather;

import com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather.model.Weather;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JSONParser {

    public Weather parseOpenMeteoJSONToWeather(String openMeteoJSON) {
        return new Weather(new JSONObject(openMeteoJSON)
                .getJSONObject("current")
                .getBigDecimal("temperature_2m"));
    }
}
