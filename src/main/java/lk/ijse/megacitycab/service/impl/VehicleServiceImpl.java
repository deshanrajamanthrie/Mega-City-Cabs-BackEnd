package lk.ijse.megacitycab.service.impl;

import lk.ijse.megacitycab.dto.VehicleDTO;
import lk.ijse.megacitycab.repostory.VehicleRepostory;
import lk.ijse.megacitycab.repostory.impl.VehicleRepostoryImpl;
import lk.ijse.megacitycab.service.VehicleService;
import lk.ijse.megacitycab.util.map.Map;

import java.io.IOException;
import java.util.List;

public class VehicleServiceImpl implements VehicleService {
    private VehicleRepostory vehicleRepostory = new VehicleRepostoryImpl();
    private Map map = new Map();
    @Override
    public void saveVehicle(VehicleDTO vehicle) throws IOException {
        vehicleRepostory.saveVehicle(map.toVehicle(vehicle));
    }

    @Override
    public List<VehicleDTO> getAllVehicle() throws IOException {
        return map.toVehicleDtoList(vehicleRepostory.getAllVehicle());
    }

    @Override
    public void updateVehicle(VehicleDTO vehicle) throws IOException {
        vehicleRepostory.updateVehicle(map.toVehicle(vehicle));
    }

    @Override
    public void deleteVehicle(String vehicle_id) throws IOException {
        vehicleRepostory.deleteVehicle(vehicle_id);
    }

    @Override
    public VehicleDTO findVehicle(String vehicle_id) throws IOException {
        return map.toVehicleDto(vehicleRepostory.findVehicle(vehicle_id));
    }
}
