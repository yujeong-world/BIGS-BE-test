package com.example.bigs_be_test.dto;

import com.example.bigs_be_test.entity.Weather;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {
    private String baseDate; //발표일자
    private String baseTime; //발표시각
    private String category; //자료 구분 문자
    private String fcstDate; //예보일자
    private String fcstTime; //예보시각
    private String fcstValue; //예보 값
    private int nx;
    private int ny;

    @Override
    public String toString() {
        return "WeatherDto{" +
                "baseDate='" + baseDate + '\'' +
                ", baseTime='" + baseTime + '\'' +
                ", fcstDate='" + fcstDate + '\'' +
                ", fcstTime='" + fcstTime + '\'' +
                ", category='" + category + '\'' +
                ", fcstValue='" + fcstValue + '\'' +
                ", nx='" + nx + '\'' +
                ", ny='" + ny + '\'' +
                '}';
    }


    public static WeatherDto fromEntity(Weather weather){
        return WeatherDto.builder()
                .baseDate(weather.getBaseDate())
                .baseTime(weather.getFcstTime())
                .fcstDate(weather.getFcstDate())
                .fcstTime(weather.getFcstTime())
                .category(weather.getCategory())
                .fcstValue(weather.getFcstValue())
                .build();
    }

}
