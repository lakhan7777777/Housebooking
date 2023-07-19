package com.houseproject.controller;

import com.houseproject.entities.Bangalore;
import com.houseproject.entities.Delhi;
import com.houseproject.entities.pune;
import com.houseproject.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/bangalore-houses")
    public List<Bangalore> getAllBangaloreHouses() {
        return houseService.getAllBangaloreHouses();
    }
    @GetMapping("/delhi-houses")
    public List<Delhi> getAllDelhiHouses() {
        return houseService.getAllDelhiHouses();
    }
    @GetMapping("/pune-houses")
    public List<pune> getAllpuneHouses() {
        return houseService.getAllpuneHouses();
    }



    @GetMapping("/delhi-houses/locality")
    public List<Delhi> getDelhiHousesByLocation(@RequestParam("locality") String locality) {
        return houseService.getHouseByLocality(locality);
    }
    @GetMapping("/bangalore-houses/location")
    public List<Bangalore> getBangaloreHousesByLocation(@RequestParam("location") String location) {
        return houseService.getHouseByLocation(location);
    }
    @GetMapping("/bangalore-houses/size")
    public List<Bangalore> getBangaloreHousesByBhk(@RequestParam("size") String size) {
        return houseService.getHouseBySize(size);
    }
    @GetMapping("/pune-houses/size")
    public List<pune> getPuneHousesByBhk(@RequestParam("size") String size) {
        return houseService.getHouseBySizes(size);
    }
    @GetMapping("/delhi-houses/bhk")
    public List<Delhi> getDelhiHousesByBhk(@RequestParam("bhk") String bhk) {
        return houseService.getHouseByBhk(bhk);
    }
    @GetMapping("/delhi-houses/bathroom")
    public List<Delhi> getDelhiHousesByBathroom(@RequestParam("bathroom") String bathroom) {
        return houseService.getHouseByBathroom(bathroom);
    }
    @GetMapping("/bangalore-houses/bath")
    public List<Bangalore> getDelhiHousesByBath(@RequestParam("bath") String bath) {
        return houseService.getHouseByBath(bath);
    }
    @GetMapping("/pune-houses/bath")
    public List<pune> getDelhiPuneByBath(@RequestParam("bath") String bath) {
        return houseService.getHouseByBaths(bath);
    }

    @GetMapping("/bangalore-houses/by-price-range")
    public List<Bangalore> getBangaloreHousesByPriceRange(
            @RequestParam("minPrice") BigDecimal minPrice, @RequestParam("maxPrice") BigDecimal maxPrice) {
        return houseService.getBangaloreHousesByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/delhi-houses/by-price-range")
    public List<Delhi> getDelhiHousesByPriceRange(
            @RequestParam("minPrice") BigDecimal minPrice, @RequestParam("maxPrice") BigDecimal maxPrice) {
        return houseService.getDelhiHousesByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/pune-houses/by-price-range")
    public List<pune> getPuneHousesByPriceRange(
            @RequestParam("minPrice") BigDecimal minPrice, @RequestParam("maxPrice") BigDecimal maxPrice) {
        return houseService.getPuneHousesByPriceRange(minPrice, maxPrice);
    }
}
