package lk.ijse.megacitycab.service.impl;

import lk.ijse.megacitycab.dto.UserDTO;
import lk.ijse.megacitycab.repostory.UserRepostory;
import lk.ijse.megacitycab.repostory.impl.UserRepostoryImpl;
import lk.ijse.megacitycab.service.UserService;
import lk.ijse.megacitycab.util.map.Map;

import java.io.IOException;

public class UserServiceImpl implements UserService {
    private UserRepostory userRepostory = new UserRepostoryImpl();
    private Map map = new Map();
    @Override
    public void SignUp(UserDTO user) throws IOException {
        userRepostory.SignUp(map.toUser(user));
    }

    @Override
    public boolean SignIn(UserDTO user) throws IOException {
        return userRepostory.SignIn(map.toUser(user));
    }
}
