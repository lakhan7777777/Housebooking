package com.houseproject.service.impl;

import com.houseproject.entities.Bangalore;
import com.houseproject.entities.Delhi;
import com.houseproject.entities.pune;
import com.houseproject.repository.BangaloreHouseRepository;
import com.houseproject.repository.DelhiHouseRepository;
import com.houseproject.repository.PuneHouseRepository;
import com.houseproject.service.HouseService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HouseServiceimpl implements HouseService {
    private final BangaloreHouseRepository bangaloreHouseRepository;
    private final DelhiHouseRepository delhiHouseRepository;
    private final PuneHouseRepository puneHouseRepository;



    public HouseServiceimpl(BangaloreHouseRepository bangaloreHouseRepository, DelhiHouseRepository delhiHouseRepository,
                        PuneHouseRepository puneHouseRepository) {
        this.bangaloreHouseRepository = bangaloreHouseRepository;
        this.delhiHouseRepository = delhiHouseRepository;
        this.puneHouseRepository = puneHouseRepository;
    }
@Override
    public List<Bangalore> getAllBangaloreHouses() {
        return bangaloreHouseRepository.findAll();
    }
    @Override
    public List<Delhi> getAllDelhiHouses() {
        return delhiHouseRepository.findAll();
    }
@Override
    public List<pune> getAllpuneHouses() {
        return puneHouseRepository.findAll();
    }

    @Override
    public List<Delhi> getHouseByLocality(String locality) {
        return delhiHouseRepository.findByLocality(locality);
    }
    @Override
    public List<Bangalore> getHouseByLocation(String location) {
        return bangaloreHouseRepository.findByLocation(location);
    }
    @Override
    public List<Bangalore> getHouseBySize(String size) {
        return bangaloreHouseRepository.findBySize(size);
    }

    @Override
    public List<Delhi> getHouseByBhk(String bhk) {
        return delhiHouseRepository.getHouseByBhk(bhk);
    }

    @Override
    public List<pune> getHouseBySizes(String size) {
        return puneHouseRepository.findBySize(size);
    }

    @Override
    public List<Delhi> getHouseByBathroom(String bathroom) {
        return delhiHouseRepository.getHouseByBathroom(bathroom);
    }

    @Override
    public List<Bangalore> getHouseByBath(String bath) {
        return bangaloreHouseRepository.getHouseByBath(bath);
    }

    @Override
    public List<pune> getHouseByBaths(String bath) {
        return puneHouseRepository.getHouseByBath(bath);
    }
    @Override
    public List<pune> getHouseBySite_Location(String site_location) {
        return puneHouseRepository.findBySite_Location(site_location);
    }
  public List<Bangalore> getBangaloreHousesByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
       return bangaloreHouseRepository.findByPriceRangeBetween(minPrice, maxPrice);
   }

    public List<Delhi> getDelhiHousesByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return delhiHouseRepository.findByPriceRangeBetween(minPrice, maxPrice);
    }

    public List<pune> getPuneHousesByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return puneHouseRepository.findByPriceRangeBetween(minPrice, maxPrice);
    }
}
