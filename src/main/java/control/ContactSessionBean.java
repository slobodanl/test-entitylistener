package control;

import entity.Customer;

import javax.ejb.Stateless;

/**
 * Created by slobodan on 2017-05-14.
 */

@Stateless
public class ContactSessionBean {
    public void setContact(Customer customer) {
        customer.setContact(System.currentTimeMillis() % 2 == 0);
    }
}
