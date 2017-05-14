package service;

import control.CrudService;
import entity.Customer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

/**
 * Created by slobodan on 2017-05-14.
 */
@Path("/customer")
public class CustomerResource {

    @Inject
    private CrudService crudService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Customer> listAll(){
        return crudService.findAll(Customer.FIND_ALL , Customer.class , Collections.emptyMap());
    }
}

