package lk.ijse.megacitycab.repostory;

import lk.ijse.megacitycab.dto.VehicleDTO;
import lk.ijse.megacitycab.entity.Vehicle;

import java.io.IOException;
import java.util.List;

public interface VehicleRepostory {
    void saveVehicle(Vehicle vehicle) throws IOException;
    List<Vehicle> getAllVehicle() throws IOException;
    void updateVehicle(Vehicle vehicle) throws IOException;
    void deleteVehicle(String vehicle_id) throws IOException;
    Vehicle findVehicle(String vehicle_id) throws IOException;
}
