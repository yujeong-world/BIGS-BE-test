package com.example.bigs_be_test.entity;

import com.example.bigs_be_test.dto.WeatherDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String baseDate;
    @Setter
    private String baseTime;
    @Setter
    private String category;
    @Setter
    private String fcstDate;
    @Setter
    private String fcstTime;
    @Setter
    private String fcstValue;
    @Setter
    private int nx;
    @Setter
    private int ny;

    public Weather toEntity(WeatherDto weatherDto) {
        Weather weather = new Weather();
        weather.setBaseDate(weatherDto.getBaseDate());
        weather.setBaseTime(weatherDto.getBaseTime());
        weather.setCategory(weatherDto.getCategory());
        weather.setFcstDate(weatherDto.getFcstDate());
        weather.setFcstTime(weatherDto.getFcstTime());
        weather.setFcstValue(weatherDto.getFcstValue());
        weather.setNx(weatherDto.getNx());
        weather.setNy(weatherDto.getNy());
        return weather;
    }
}
