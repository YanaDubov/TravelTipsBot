package com.travel.bot.service;

import com.travel.bot.model.CityInfo;

import java.util.List;

public interface CityInfoService {

    List<CityInfo> getCityInfo(String cityName);

    void deleteCityInfo(String cityName);

    CityInfo saveCityInfo(CityInfo cityInfo);

    CityInfo updateCityInfo(CityInfo cityInfo);
}
