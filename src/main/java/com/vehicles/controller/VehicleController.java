package com.vehicles.controller;

import com.vehicles.model.Vehicle;
import com.vehicles.repository.VehicleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VehicleController {
    
    private final VehicleRepository vehicleRepository;
    
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return ResponseEntity.ok(vehicles);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable String id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable String id, @Valid @RequestBody Vehicle vehicleDetails) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        
        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            vehicle.setBrand(vehicleDetails.getBrand());
            vehicle.setModel(vehicleDetails.getModel());
            vehicle.setYear(vehicleDetails.getYear());
            vehicle.setPrice(vehicleDetails.getPrice());
            
            Vehicle updatedVehicle = vehicleRepository.save(vehicle);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/search/brand/{brand}")
    public ResponseEntity<List<Vehicle>> getVehiclesByBrand(@PathVariable String brand) {
        List<Vehicle> vehicles = vehicleRepository.findByBrandContainingIgnoreCase(brand);
        return ResponseEntity.ok(vehicles);
    }
    
    @GetMapping("/search/model/{model}")
    public ResponseEntity<List<Vehicle>> getVehiclesByModel(@PathVariable String model) {
        List<Vehicle> vehicles = vehicleRepository.findByModelContainingIgnoreCase(model);
        return ResponseEntity.ok(vehicles);
    }
    
    @GetMapping("/search/year/{year}")
    public ResponseEntity<List<Vehicle>> getVehiclesByYear(@PathVariable Integer year) {
        List<Vehicle> vehicles = vehicleRepository.findByYear(year);
        return ResponseEntity.ok(vehicles);
    }
    
    @GetMapping("/search/price/{maxPrice}")
    public ResponseEntity<List<Vehicle>> getVehiclesByMaxPrice(@PathVariable Double maxPrice) {
        List<Vehicle> vehicles = vehicleRepository.findByPriceLessThanEqual(maxPrice);
        return ResponseEntity.ok(vehicles);
    }
}