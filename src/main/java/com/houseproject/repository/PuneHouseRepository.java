package com.houseproject.repository;



import com.houseproject.entities.pune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PuneHouseRepository extends JpaRepository<pune, Long> {
    List<pune> findBySize(String size);

    List<pune> getHouseByBath(String bath);
    List<pune> findByPriceRangeBetween(BigDecimal minPrice, BigDecimal maxPrice);


     List<pune> findBySite_Location(String site_location);
}


