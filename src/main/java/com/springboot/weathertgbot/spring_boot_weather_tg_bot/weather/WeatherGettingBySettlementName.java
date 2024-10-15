package com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather;

import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.objects.Message;

public class WeatherGettingBySettlementName extends WeatherGettingStrategy {
    @Override
    public JSONObject getWeather(Message telegramMessage) {
        return null;
    }
}
