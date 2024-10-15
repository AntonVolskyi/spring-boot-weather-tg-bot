package com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather;

import org.json.JSONObject;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public abstract class WeatherGettingStrategy {

    abstract public JSONObject getWeather(Message telegramMessage);

    protected JSONObject getWeatherByUrl(String url) {
        Scanner inputStream = null;
        StringBuilder sb = null;
        try {
            URL urlToExecute = new URL(url);
            inputStream = new Scanner((InputStream) urlToExecute.getContent());
            sb = new StringBuilder();
            while (inputStream.hasNext()) {
                sb.append(inputStream.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(inputStream)) {
                inputStream.close();
            }
        }
        return new JSONObject(sb.toString());
    }
}
