package com.vehicles;

import com.vehicles.model.Vehicle;
import com.vehicles.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.vehicles.repository")
public class VehicleApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(VehicleApiApplication.class, args);
    }
    
    @Bean
    CommandLineRunner initDatabase(VehicleRepository repository) {
        return args -> {
            // Verificar si ya existen datos
            if (repository.count() == 0) {
                // Insertar datos de ejemplo
                repository.save(new Vehicle(null, "Toyota", "Corolla", 2023, 25000.0));
                repository.save(new Vehicle(null, "Honda", "Civic", 2023, 22000.0));
                repository.save(new Vehicle(null, "Ford", "Mustang", 2023, 35000.0));
                repository.save(new Vehicle(null, "BMW", "X5", 2023, 60000.0));
                repository.save(new Vehicle(null, "Mercedes", "C-Class", 2023, 45000.0));
                
                System.out.println("✅ Datos de ejemplo insertados en la base de datos");
            } else {
                System.out.println("ℹ️ La base de datos ya contiene datos");
            }
        };
    }
}