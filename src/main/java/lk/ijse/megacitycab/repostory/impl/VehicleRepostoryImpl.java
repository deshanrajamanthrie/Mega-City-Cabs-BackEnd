package lk.ijse.megacitycab.repostory.impl;

import lk.ijse.megacitycab.config.FactoryConfiguration;
import lk.ijse.megacitycab.entity.Vehicle;
import lk.ijse.megacitycab.repostory.VehicleRepostory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.util.List;

public class VehicleRepostoryImpl implements VehicleRepostory {
    @Override
    public void saveVehicle(Vehicle vehicle) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(vehicle);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Vehicle> getAllVehicle() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM vehicle");
        nativeQuery.addEntity(Vehicle.class);
        List<Vehicle> resultList = nativeQuery.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public void updateVehicle(Vehicle vehicle) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(vehicle);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteVehicle(String vehicle_id) throws IOException {
        System.out.println(vehicle_id);
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Vehicle vehicle = session.get(Vehicle.class,vehicle_id);
        session.remove(vehicle);
        transaction.commit();
        session.close();
    }

    @Override
    public Vehicle findVehicle(String vehicle_id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Vehicle vehicle = session.get(Vehicle.class,vehicle_id);
        session.close();
        return vehicle;
    }
}
