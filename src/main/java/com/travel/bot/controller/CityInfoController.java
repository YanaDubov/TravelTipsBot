package com.travel.bot.controller;

import com.travel.bot.model.CityInfo;
import com.travel.bot.service.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/city")
public class CityInfoController {

    private final CityInfoService service;

    @Autowired
    public CityInfoController(CityInfoService service) {
        this.service = service;
    }

    @GetMapping(path = "/info/{cityName}")
    public ResponseEntity<CityInfo> getCityInfo(@PathVariable("cityName") String cityName) {
        return service.getCityInfo(cityName)
                .stream()
                .findFirst()
                .map(cityInfo -> ResponseEntity.ok(cityInfo))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/info/{cityName}")
    public ResponseEntity<?> deleteCityInfo(@PathVariable("cityName") String cityName) {
        service.deleteCityInfo(cityName);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/info")
    public ResponseEntity<?> getCityInfo(@RequestBody CityInfo cityInfo) {
        return ResponseEntity.ok(service.saveCityInfo(cityInfo));
    }

    @PutMapping(path = "/info")
    public ResponseEntity<?> updateCityInfo(@RequestBody CityInfo cityInfo) {
        return ResponseEntity.ok(service.updateCityInfo(cityInfo));
    }

}
