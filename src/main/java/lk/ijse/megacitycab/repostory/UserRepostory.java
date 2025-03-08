package lk.ijse.megacitycab.repostory;

import lk.ijse.megacitycab.entity.User;

import java.io.IOException;

public interface UserRepostory {
    void SignUp(User user) throws IOException;
    boolean SignIn(User user) throws IOException;
}
