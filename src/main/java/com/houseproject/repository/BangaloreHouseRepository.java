package com.houseproject.repository;

import com.houseproject.entities.Bangalore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BangaloreHouseRepository extends JpaRepository<Bangalore, Long> {
    List<Bangalore> findByLocation(String location);
    List<Bangalore> findBySize(String size);

    List<Bangalore> getHouseByBath(String bath);
    //List<Bangalore> findByPriceRangeBetween(BigDecimal minPrice, BigDecimal maxPrice);
}

