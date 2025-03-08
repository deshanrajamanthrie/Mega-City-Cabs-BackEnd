package lk.ijse.megacitycab.dto;

import lk.ijse.megacitycab.util.enums.FuelType;
import lk.ijse.megacitycab.util.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private String vehicleId;
    private String driverId;
    private String brand;
    private String color;
    private double pricePreMilage;
    private String licanePlateNumber;
    private FuelType fuelType;
    private Status status;
}
