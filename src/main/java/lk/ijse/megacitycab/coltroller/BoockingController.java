package lk.ijse.megacitycab.coltroller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.megacitycab.dto.BoockingDTO;
import lk.ijse.megacitycab.service.BoockingService;
import lk.ijse.megacitycab.service.impl.BoockingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/booking")
public class BoockingController extends HttpServlet {
    private Jsonb jsonb = JsonbBuilder.create();
    private BoockingService boockingService = new BoockingServiceImpl();

    private static final Logger logger = LoggerFactory.getLogger(CutomerController.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(PrintWriter printWriter = resp.getWriter()){
            String booking_id = req.getParameter("booking_id");
            if(booking_id == null){
                printWriter.println(jsonb.toJson(boockingService.getAllBoocking()));
            }else{
                printWriter.println(jsonb.toJson(boockingService.findBoocking(booking_id)));
            }

        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            BoockingDTO booking = jsonb.fromJson(req.getReader(), BoockingDTO.class);
            boockingService.saveBoocking(booking);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            BoockingDTO booking = jsonb.fromJson(req.getReader(), BoockingDTO.class);
            boockingService.updateBoocking(booking);
            resp.setStatus(HttpServletResponse.SC_OK);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String booking_id = req.getParameter("booking_id");
            boockingService.deleteBoocking(booking_id);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }
}
