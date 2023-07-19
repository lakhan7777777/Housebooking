package com.houseproject.repository;

import com.houseproject.entities.Delhi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface DelhiHouseRepository extends JpaRepository<Delhi, Long> {

    List<Delhi> findByLocality(String locality);



    List<Delhi> getHouseByBhk(String bhk);

    List<Delhi> getHouseByBathroom(String bathroom);


    //List<Delhi> findByPriceRangeBetween(BigDecimal minPrice, BigDecimal maxPrice);
}


