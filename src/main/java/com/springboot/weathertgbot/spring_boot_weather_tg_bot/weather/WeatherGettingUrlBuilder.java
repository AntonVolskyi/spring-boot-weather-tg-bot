package com.springboot.weathertgbot.spring_boot_weather_tg_bot.weather;

import java.util.Objects;

public class WeatherGettingUrlBuilder {
    private static final String OPEN_METEO_FORECAST_URL = "https://api.open-meteo.com/v1/forecast";
    private static final String LATITUDE_URL_PARAM = "latitude=";
    private static final String LONGITUDE_URL_PARAM = "longitude=";
    private static final String CURRENT_METEO_INFO = "current=";
    private static final String TIMEZONE_PARAM = "timezone=auto";
    private static final String TEMPERATURE_FLAG = "temperature_2m";

    private Double latitude;
    private Double longitude;

    public void setCoordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String buildUrl() {
        if (Objects.isNull(latitude) || Objects.isNull(longitude)) {
            throw new IllegalArgumentException("longitude or latitude does not exists");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(OPEN_METEO_FORECAST_URL).append("?")
                .append(LATITUDE_URL_PARAM).append(latitude).append("&")
                .append(LONGITUDE_URL_PARAM).append(longitude).append("&")
                .append(TIMEZONE_PARAM).append("&")
                .append(CURRENT_METEO_INFO).append(TEMPERATURE_FLAG);
        return sb.toString();
    }
}
