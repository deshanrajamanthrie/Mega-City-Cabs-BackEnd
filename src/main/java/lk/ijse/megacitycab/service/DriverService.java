package lk.ijse.megacitycab.service;

import lk.ijse.megacitycab.dto.DriverDTO;

import java.io.IOException;
import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO driver) throws IOException;
    List<DriverDTO> getAllDriver() throws IOException;
    void updateDriver(DriverDTO driver) throws IOException;
    void deleteDriver(String driver_id) throws IOException;
    DriverDTO findDriver(String driver_id) throws IOException;
}
