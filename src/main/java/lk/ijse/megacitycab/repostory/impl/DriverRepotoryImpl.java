package lk.ijse.megacitycab.repostory.impl;

import lk.ijse.megacitycab.config.FactoryConfiguration;
import lk.ijse.megacitycab.entity.Driver;
import lk.ijse.megacitycab.repostory.DriverRepostory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.util.List;

public class DriverRepotoryImpl implements DriverRepostory {
    @Override
    public void saveDriver(Driver driver) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(driver);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Driver> getAllDriver() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM driver");
        nativeQuery.addEntity(Driver.class);
        List<Driver> drivers = nativeQuery.getResultList();
        session.close();
        return drivers;
    }

    @Override
    public void updateDriver(Driver driver) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(driver);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteDriver(String driver_id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Driver driver = session.get(Driver.class,driver_id);
        session.remove(driver);
        transaction.commit();
        session.close();
    }

    @Override
    public Driver findDriver(String driver_id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Driver driver = session.get(Driver.class,driver_id);
        session.close();
        return driver;
    }
}
