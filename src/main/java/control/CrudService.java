/*
 * Copyright (c) 2014, Axis Communications AB. All rights reserved.
 */
package control;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;


@Stateless
public class CrudService {


	@Inject
	@MyEntityManager
	EntityManager em;

	public <T> T create(T t) {
		this.em.persist(t);
		return t;
	}

	public void flash() {
		this.em.flush();
	}


	public <T> List<T> findAll(String namedQuery, Class<T> clazz, Map<String, Object> parameters) {

		TypedQuery<T> query = em.createNamedQuery(namedQuery, clazz);

		Optional.ofNullable(parameters).orElse(Collections.emptyMap()).forEach(query::setParameter);

		return query.getResultList();
	}

}
