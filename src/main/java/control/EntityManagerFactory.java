package control;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by slobodan on 2017-05-14.
 */
@ApplicationScoped
public class EntityManagerFactory {


    @Produces
    @MyEntityManager
    @PersistenceContext
    private EntityManager em;


}
