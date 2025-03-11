package lk.ijse.megacitycab.coltroller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.megacitycab.dto.CustomerDTO;
import lk.ijse.megacitycab.service.CustomerService;
import lk.ijse.megacitycab.service.impl.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/customer")
public class CutomerController extends HttpServlet {

    private Jsonb jsonb = JsonbBuilder.create();
    private CustomerService customerService = new CustomerServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(CutomerController.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(PrintWriter printWriter = resp.getWriter()){

            String customerId = req.getParameter("registration_number");

            if(customerId==null){
                printWriter.println(jsonb.toJson(customerService.getAllCustomer()));
            }else{
                printWriter.println(jsonb.toJson(customerService.findCustomer(customerId)));
            }

        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try{
            CustomerDTO customer = jsonb.fromJson(req.getReader(), CustomerDTO.class);
            customerService.saveCustomer(customer);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            CustomerDTO customer = jsonb.fromJson(req.getReader(), CustomerDTO.class);
            customerService.updateCustomer(customer);
            resp.setStatus(HttpServletResponse.SC_OK);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String customerId = req.getParameter("registration_number");
            customerService.deleteCustomer(customerId);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }catch (Exception e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            logger.error(e.getMessage());
        }

    }
}
