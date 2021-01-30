package com.travel.bot.service;

import com.travel.bot.repository.CityInfoRepository;
import com.travel.bot.model.CityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
public class MyCityInfoService implements CityInfoService {

    private final CityInfoRepository cityInfoRepository;

    @Autowired
    public MyCityInfoService(CityInfoRepository cityInfoRepository) {
        this.cityInfoRepository = cityInfoRepository;
    }

    public Optional<CityInfo> getCityInfo(String cityName){
        return cityInfoRepository.findCityInfoByName(cityName);
    }

    public void deleteCityInfo(String cityName){
        cityInfoRepository.deleteCityInfoByName(cityName);
    }

    public CityInfo saveCityInfo(CityInfo cityInfo){
        return cityInfoRepository.save(cityInfo);
    }

    public CityInfo updateCityInfo(CityInfo cityInfo){
        CityInfo newCityInfo = cityInfoRepository.findCityInfoByName(cityInfo.getName())
                .map(city -> {
                    city.setDescription(cityInfo.getDescription());
                    return city;
                }).orElse(cityInfo);
        return cityInfoRepository.save(newCityInfo);
    }
}
