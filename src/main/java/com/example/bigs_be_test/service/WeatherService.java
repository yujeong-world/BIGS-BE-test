package com.example.bigs_be_test.service;

import com.example.bigs_be_test.dto.WeatherDto;
import com.example.bigs_be_test.dto.WeatherResponseDto;
import com.example.bigs_be_test.entity.Weather;
import com.example.bigs_be_test.repository.WeatherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository){
        this.weatherRepository = weatherRepository;
    }

    public void getWeatherAndSave() {
        WeatherResponseDto responseDto = getWeather();
        if (responseDto != null && responseDto.getResponse() != null && responseDto.getResponse().getBody() != null) {
            for (WeatherDto weatherDto : responseDto.getResponse().getBody().getItems().getItem()) {
                Weather weather = new Weather();
                weatherRepository.save(weather.toEntity(weatherDto));
            }
        }
    }

    public List<WeatherDto> getWeatherList(){
        List<Weather> weatherList = weatherRepository.findAll();

        List<WeatherDto> weatherDtoList = new ArrayList<>();

        for (Weather weather : weatherList){
            WeatherDto weatherDto = WeatherDto.fromEntity(weather);
            weatherDtoList.add(weatherDto);
        }

        System.out.println(weatherDtoList);

        return weatherDtoList;

    }


    public WeatherResponseDto getWeather(){
        //요청을 보낼 URL
        String baseUrl  = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst";

        // 파라미터 설정
        // serviceKey - 공공 api에서 받아온 키 값
        String serviceKey = "키 값을 넣어주세요!";
        String numOfRows = "50";
        String pageNo = "1";
        // 조회할 날짜 (최근3일만 조회 가능함)
        String baseDate = "20240521";
        String baseTime = "0500";
        String nx = "62";
        String ny = "13";
        String dataType = "json";

        // UriComponentsBuilder를 사용하여 파라미터를 추가하여 URI 생성
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("serviceKey", serviceKey)
                .queryParam("numOfRows", numOfRows)
                .queryParam("pageNo", pageNo)
                .queryParam("base_date", baseDate)
                .queryParam("base_time", baseTime)
                .queryParam("nx", nx)
                .queryParam("ny", ny)
                .queryParam("dataType", dataType)
                .build(true)  // 여기서 true를 사용하여 인코딩 방지
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        //Http GET 요청 보내기
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);


        //응답값
        String responseBody = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        try {
            // JSON 문자열을 DTO로 변환
            WeatherResponseDto weatherResponseDto = mapper.readValue(responseBody, WeatherResponseDto.class);
            return weatherResponseDto;
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
            return null;
        }


    }
}
