package com.vehicles.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    
    private String id;
    
    @NotBlank(message = "Brand is required")
    @Size(min = 2, max = 50, message = "Brand must be between 2 and 50 characters")
    private String brand;
    
    @NotBlank(message = "Model is required")
    @Size(min = 1, max = 100, message = "Model must be between 1 and 100 characters")
    private String model;
    
    @NotNull(message = "Year is required")
    @Min(value = 1900, message = "Year must be greater than or equal to 1900")
    private Integer year;
    
    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private Double price;
}