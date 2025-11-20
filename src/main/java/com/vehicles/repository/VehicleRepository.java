package com.vehicles.repository;

import com.vehicles.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    
    List<Vehicle> findByBrandContainingIgnoreCase(String brand);
    
    List<Vehicle> findByModelContainingIgnoreCase(String model);
    
    List<Vehicle> findByYear(Integer year);
    
    List<Vehicle> findByBrandAndModel(String brand, String model);
    
    List<Vehicle> findByPriceLessThanEqual(Double price);
    
    List<Vehicle> findByYearBetween(Integer startYear, Integer endYear);
}