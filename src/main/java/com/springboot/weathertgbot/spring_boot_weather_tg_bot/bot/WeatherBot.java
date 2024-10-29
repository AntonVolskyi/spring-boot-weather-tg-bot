package com.springboot.weathertgbot.spring_boot_weather_tg_bot.bot;

import com.springboot.weathertgbot.spring_boot_weather_tg_bot.service.OpenMeteoService;
import com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class WeatherBot extends TelegramLongPollingBot {

    @Autowired
    private OpenMeteoService openMeteoService;
    private String botName;

    public WeatherBot(String botName, String botToken) {
        super(botToken);
        this.botName = botName;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        Weather weather
                = openMeteoService.weatherByCoordinates(message.getLocation().getLatitude(), message.getLocation().getLongitude());
        try {
            execute(new SendMessage(chatId.toString(), weather.toString()));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }
}
