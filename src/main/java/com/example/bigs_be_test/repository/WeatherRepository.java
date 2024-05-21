package com.example.bigs_be_test.repository;

import com.example.bigs_be_test.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
