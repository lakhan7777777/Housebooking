package com.houseproject.service;

import com.houseproject.entities.Bangalore;
import com.houseproject.entities.Delhi;
import com.houseproject.entities.pune;

import java.math.BigDecimal;
import java.util.List;

public interface HouseService {
    List<Bangalore> getAllBangaloreHouses();


    List<Delhi> getAllDelhiHouses();

    List<pune> getAllpuneHouses();

     List<Delhi> getHouseByLocality(String locality);


    List<Bangalore> getHouseByLocation(String location);



    List<Bangalore> getHouseBySize(String size);

    List<Delhi> getHouseByBhk(String bhk);

    List<pune> getHouseBySizes(String size);

    List<Delhi> getHouseByBathroom(String bathroom);

    List<Bangalore> getHouseByBath(String bath);

    List<pune> getHouseByBaths(String bath);
    List<Delhi> getDelhiHousesByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<pune> getPuneHousesByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<Bangalore> getBangaloreHousesByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
}
