package com.example.bigs_be_test.controller;

import com.example.bigs_be_test.dto.WeatherDto;
import com.example.bigs_be_test.service.WeatherService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    //1. 단기 예보를 DB에 저장하게 하는 API
    @PostMapping("/list")
    public void getWeather(){
        weatherService.getWeatherAndSave();

    }

    //2. 단기 예보를 조회하는 API
    @GetMapping("/list")
    public ResponseEntity<List<WeatherDto>> getWeatherInfo(){
        List<WeatherDto> weatherDtoList = weatherService.getWeatherList();
        if (weatherDtoList.isEmpty()) {
            System.out.println("조회할 데이터가 없습니다.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        System.out.println("단기예보 조회 API 테스트 "+weatherDtoList);
        return ResponseEntity.ok(weatherDtoList);
    }


}
