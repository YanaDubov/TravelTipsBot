package com.travel.bot.service;

import com.travel.bot.model.CityInfo;

import java.util.Optional;

public interface CityInfoService {

    Optional<CityInfo> getCityInfo(String cityName);

    void deleteCityInfo(String cityName);

    CityInfo saveCityInfo(CityInfo cityInfo);

    CityInfo updateCityInfo(CityInfo cityInfo);
}
