package lk.ijse.megacitycab.service;

import lk.ijse.megacitycab.dto.BoockingDTO;

import java.io.IOException;
import java.util.List;

public interface BoockingService {
    void saveBoocking(BoockingDTO boocking) throws IOException;
    List<BoockingDTO> getAllBoocking() throws IOException;
    void updateBoocking(BoockingDTO boocking) throws IOException;
    void deleteBoocking(String booking_id) throws IOException;
    BoockingDTO findBoocking(String booking_id) throws IOException;
}
