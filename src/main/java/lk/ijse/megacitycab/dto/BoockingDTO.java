package lk.ijse.megacitycab.dto;

import lk.ijse.megacitycab.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoockingDTO {
    private String booking_Id;
    private String date;
    private String registration_number;
    private String vehicleId;
    private double price;
}
