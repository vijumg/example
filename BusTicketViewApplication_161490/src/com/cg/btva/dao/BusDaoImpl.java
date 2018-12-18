package com.cg.btva.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.cg.btva.bean.BusBean;

@Repository
@Transactional
public class BusDaoImpl implements IBusDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BusBean> getAllBusDetails() {
		TypedQuery<BusBean> query = entityManager.createQuery(
				"SELECT b FROM BusBean b", BusBean.class);
		return query.getResultList();
	}

}
