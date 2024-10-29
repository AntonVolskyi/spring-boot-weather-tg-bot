package com.springboot.weathertgbot.spring_boot_weather_tg_bot.service;

import com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather.JSONParser;
import com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather.UrlReader;
import com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather.model.Weather;
import org.springframework.stereotype.Service;

@Service
public class OpenMeteoService {

    private UrlReader urlReader;
    private JSONParser jsonParser;

    public OpenMeteoService(UrlReader urlReader, JSONParser jsonParser) {
        this.urlReader = urlReader;
        this.jsonParser = jsonParser;
    }

    public Weather weatherByCoordinates(Double latitude, Double longitude) {
        String openMeteoJSON = urlReader.readDataFromUrl(latitude, longitude);
        return jsonParser.parseOpenMeteoJSONToWeather(openMeteoJSON);
    }
}
