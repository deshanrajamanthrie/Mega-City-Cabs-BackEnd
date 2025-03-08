package lk.ijse.megacitycab.coltroller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.megacitycab.dto.UserDTO;
import lk.ijse.megacitycab.service.DriverService;
import lk.ijse.megacitycab.service.UserService;
import lk.ijse.megacitycab.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user")
public class UserController extends HttpServlet {

    private Jsonb jsonb = JsonbBuilder.create();
    private static final Logger logger = LoggerFactory.getLogger(CutomerController.class);
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDTO user = jsonb.fromJson(req.getReader(), UserDTO.class);
            userService.SignUp(user);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter printWriter = resp.getWriter()){
            UserDTO user = jsonb.fromJson(req.getReader(), UserDTO.class);
            boolean isTrue = userService.SignIn(user);
            printWriter.println(isTrue);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }
}
