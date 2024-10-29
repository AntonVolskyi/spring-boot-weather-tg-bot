package com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

@Component
public class UrlReader {

    private UrlBuilder urlBuilder;

    public UrlReader(UrlBuilder urlBuilder) {
        this.urlBuilder = urlBuilder;
    }

    public String readDataFromUrl(Double latitude, Double longitude) {
        URL url;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            url = new URL(urlBuilder.buildUrl(latitude, longitude));
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            br.lines().forEach(sb::append);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(br).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
