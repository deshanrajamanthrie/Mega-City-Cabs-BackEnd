package lk.ijse.megacitycab.coltroller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.megacitycab.dto.DriverDTO;
import lk.ijse.megacitycab.service.impl.DriverSerivceImpl;
import lk.ijse.megacitycab.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/driver")
public class DriverController extends HttpServlet {
    private Jsonb jsonb = JsonbBuilder.create();
    private DriverService driverService = new DriverSerivceImpl();
    private static final Logger logger = LoggerFactory.getLogger(CutomerController.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            DriverDTO driver = jsonb.fromJson(req.getReader(), DriverDTO.class);
            driverService.saveDriver(driver);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter printWriter = resp.getWriter()){
            String driver_id = req.getParameter("driver_id");
            if(driver_id == null){
                printWriter.write(jsonb.toJson(driverService.getAllDriver()));
            }else {
                printWriter.write(jsonb.toJson(driverService.findDriver(driver_id)));
            }

        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            DriverDTO driver = jsonb.fromJson(req.getReader(), DriverDTO.class);
            driverService.updateDriver(driver);
            resp.setStatus(HttpServletResponse.SC_OK);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String driver_id = req.getParameter("driver_id");
            driverService.deleteDriver(driver_id);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }
}
