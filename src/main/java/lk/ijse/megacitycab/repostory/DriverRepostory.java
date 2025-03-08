package lk.ijse.megacitycab.repostory;

import lk.ijse.megacitycab.dto.DriverDTO;
import lk.ijse.megacitycab.entity.Driver;

import java.io.IOException;
import java.util.List;

public interface DriverRepostory{
    void saveDriver(Driver driver) throws IOException;
    List<Driver> getAllDriver() throws IOException;
    void updateDriver(Driver driver) throws IOException;
    void deleteDriver(String driver_id) throws IOException;
    Driver findDriver(String driver_id) throws IOException;
}
