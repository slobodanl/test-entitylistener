package entity;

import control.CustomerListener;
import org.eclipse.persistence.config.QueryHints;

import javax.persistence.*;

/**
 * Created by slobodan on 2017-05-14.
 */
@Entity
@EntityListeners({CustomerListener.class})
@NamedQueries({
        @NamedQuery(name = Customer.FIND_ALL, query = "SELECT c FROM Customer c", hints = {
                @QueryHint(name= QueryHints.QUERY_RESULTS_CACHE, value="TRUE")}),

})
public class Customer {

    public static final String FIND_ALL = "Customer.findAll";


    @Id
    private Long id;

    @Column
    private String name;



    @Transient
    private boolean contact;

    public Customer() {
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContact() {
        return contact;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }
}
