package lk.ijse.megacitycab.repostory;

import lk.ijse.megacitycab.entity.Booking;

import java.io.IOException;
import java.util.List;

public interface BoockingRepostory {
    void saveBoocking(Booking booking) throws IOException;
    List<Booking> getAllBoocking() throws IOException;
    void updateBoocking(Booking booking) throws IOException;
    void deleteBoocking(String booking_id) throws IOException;
    Booking findBoocking(String booking_id) throws IOException;
}
