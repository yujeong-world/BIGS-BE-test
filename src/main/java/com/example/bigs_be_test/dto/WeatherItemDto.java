package com.example.bigs_be_test.dto;

import java.util.List;

public class WeatherItemDto {
    private List<WeatherDto> item;

    public List<WeatherDto> getItem() {
        return item;
    }

    public void setItem(List<WeatherDto> item) {
        this.item = item;
    }
}
