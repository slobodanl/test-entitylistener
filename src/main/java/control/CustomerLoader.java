package control;

import entity.Customer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.stream.LongStream;

/**
 * Created by slobodan on 2017-05-14.
 */
@Singleton
public class CustomerLoader {

    @Inject
    CrudService crudService;



    public void init(@Observes @Initialized(ApplicationScoped.class) Object event) {
        LongStream.range(1,1500).forEach(id -> {
            Customer customer = new Customer(id  , String.format("customer-%s" , id));
            crudService.create(customer);
        });
        crudService.flash();
    }
}
