package lk.ijse.megacitycab.coltroller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.megacitycab.dto.VehicleDTO;
import lk.ijse.megacitycab.service.VehicleService;
import lk.ijse.megacitycab.service.impl.VehicleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Writer;

@WebServlet(urlPatterns = "/vehicle")
public class VehicleController extends HttpServlet {

    private Jsonb jsonb = JsonbBuilder.create();
    private VehicleService vehicleService = new VehicleServiceImpl();

    private static final Logger logger = LoggerFactory.getLogger(CutomerController.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Writer writer = resp.getWriter()){
            String vehicle_id = req.getParameter("vehicle_id");

            if(vehicle_id==null){
                writer.write(jsonb.toJson(vehicleService.getAllVehicle()));
            }else{
                writer.write(jsonb.toJson(vehicleService.findVehicle(vehicle_id)));
            }

        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            VehicleDTO vehicle = jsonb.fromJson(req.getReader(), VehicleDTO.class);
            vehicleService.saveVehicle(vehicle);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            VehicleDTO vehicle = jsonb.fromJson(req.getReader(), VehicleDTO.class);
            vehicleService.updateVehicle(vehicle);
            resp.setStatus(HttpServletResponse.SC_OK);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String vehicle_id = req.getParameter("vehicle_id");
            vehicleService.deleteVehicle(vehicle_id);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }
}
