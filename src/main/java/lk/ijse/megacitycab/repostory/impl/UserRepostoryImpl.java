package lk.ijse.megacitycab.repostory.impl;

import lk.ijse.megacitycab.config.FactoryConfiguration;
import lk.ijse.megacitycab.entity.User;
import lk.ijse.megacitycab.repostory.UserRepostory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class UserRepostoryImpl implements UserRepostory {
    @Override
    public void SignUp(User user) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public boolean SignIn(User user) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        User foundUser = session.get(User.class,user.getEmail());
        session.close();
        return foundUser.getPassword().equals(user.getPassword()) ? true :false;
    }
}
