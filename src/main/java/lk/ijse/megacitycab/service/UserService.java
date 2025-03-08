package lk.ijse.megacitycab.service;

import lk.ijse.megacitycab.dto.UserDTO;
import lk.ijse.megacitycab.entity.User;

import java.io.IOException;

public interface UserService {
    void SignUp(UserDTO user) throws IOException;
    boolean SignIn(UserDTO user) throws IOException;
}
