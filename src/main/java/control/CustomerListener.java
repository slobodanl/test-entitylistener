package control;

import entity.Customer;

import javax.inject.Inject;
import javax.persistence.PostLoad;

/**
 * Created by slobodan on 2017-05-14.
 */
public class CustomerListener {

    @Inject
    ContactSessionBean contactSessionBean;

    @PostLoad
    private void setContact(Customer customer) {
        contactSessionBean.setContact(customer);
    }
}
