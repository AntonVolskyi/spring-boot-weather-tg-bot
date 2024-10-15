package com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather;

import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;

public class WeatherGettingByCoordinates extends WeatherGettingStrategy {

    @Override
    public JSONObject getWeather(Message telegramMessage) {
        Location location = telegramMessage.getLocation();
        WeatherGettingUrlBuilder weatherGettingUrlBuilder = new WeatherGettingUrlBuilder();
        weatherGettingUrlBuilder.setCoordinates(location.getLatitude(), location.getLongitude());
        JSONObject jsonWeather = getWeatherByUrl(weatherGettingUrlBuilder.buildUrl());
        return jsonWeather;
    }
}
