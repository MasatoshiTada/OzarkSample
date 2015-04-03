package ozarksample.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import ozarksample.entity.Manufacturer;
import ozarksample.service.ManufacturerService;

@Path("manufacturer")
@RequestScoped
public class ManufacturerController {
    @Inject
    private ManufacturerService manufacturerService;
    
    @Inject
    private Models models;

    @GET
    @Path("input")
    @Controller
    public String input() {
        return "manufacturer/input.html";
    }
    
    @GET
    @Path("find")
    @Controller
    public String findById(@QueryParam("id") Integer id) {
        Manufacturer manufacturer = manufacturerService.findById(id);
        models.put("manufacturer", manufacturer);
        return "manufacturer/result.html";
    }
}
