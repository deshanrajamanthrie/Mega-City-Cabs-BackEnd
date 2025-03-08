package lk.ijse.megacitycab.service;

import lk.ijse.megacitycab.dto.DriverDTO;
import lk.ijse.megacitycab.dto.VehicleDTO;

import java.io.IOException;
import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicle) throws IOException;
    List<VehicleDTO> getAllVehicle() throws IOException;
    void updateVehicle(VehicleDTO vehicle) throws IOException;
    void deleteVehicle(String vehicle_id) throws IOException;
    VehicleDTO findVehicle(String vehicle_id) throws IOException;
}
