package lk.ijse.megacitycab.repostory.impl;

import lk.ijse.megacitycab.config.FactoryConfiguration;
import lk.ijse.megacitycab.entity.Booking;
import lk.ijse.megacitycab.entity.Vehicle;
import lk.ijse.megacitycab.repostory.BoockingRepostory;
import lk.ijse.megacitycab.util.enums.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.util.List;

public class BoockingRepostoryImpl implements BoockingRepostory {
    @Override
    public void saveBoocking(Booking booking) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Vehicle vehicle = session.get(Vehicle.class,booking.getVehicle().getVehicleId());
        vehicle.setStatus(Status.INAVILABLE);
        session.save(booking);
        session.update(vehicle);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Booking> getAllBoocking() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM booking");
        nativeQuery.addEntity(Booking.class);
        List<Booking> bookings = nativeQuery.getResultList();
        session.close();
        return bookings;
    }

    @Override
    public void updateBoocking(Booking booking) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(booking);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteBoocking(String booking_id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Booking booking = session.get(Booking.class,booking_id);
        Vehicle vehicle = session.get(Vehicle.class,booking.getVehicle().getVehicleId());
        vehicle.setStatus(Status.AVILABLE);
        session.remove(booking);
        session.update(vehicle);
        transaction.commit();
        session.close();
    }

    @Override
    public Booking findBoocking(String booking_id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Booking booking = session.get(Booking.class,booking_id);
        session.close();
        return booking;
    }
}
