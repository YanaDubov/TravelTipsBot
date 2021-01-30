package com.travel.bot.repository;

import com.travel.bot.model.CityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityInfoRepository extends JpaRepository<CityInfo, Long> {

    List<CityInfo> findCityInfoByName(String name);

    void deleteCityInfoByName(String name);
}
