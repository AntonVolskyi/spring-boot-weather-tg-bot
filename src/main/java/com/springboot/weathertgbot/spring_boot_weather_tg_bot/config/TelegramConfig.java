package com.springboot.weathertgbot.spring_boot_weather_tg_bot.config;

import com.springboot.weathertgbot.spring_boot_weather_tg_bot.bot.WeatherBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramConfig {
    @Bean
    public WeatherBot weatherBot(@Value("${telegram.bot.name}")String botName,
                                 @Value("${telegram.bot.token}")String botToken) {
        WeatherBot weatherBot = new WeatherBot(botName, botToken);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(weatherBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return weatherBot;
    }
}
