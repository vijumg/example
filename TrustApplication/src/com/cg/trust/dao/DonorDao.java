package com.cg.trust.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.trust.beans.DonorBean;

@Repository
@Transactional
public class DonorDao implements IDonorDao
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public DonorBean addDonation(DonorBean donor) {		
		entityManager.persist(donor);
		entityManager.flush();
		return donor;
	}

	@Override
	public DonorBean getDonationDetails(int donorId) {		
		return entityManager.find(DonorBean.class, donorId);
	}

	@Override
	public List<DonorBean> getAllDonorsDetails() {
		TypedQuery<DonorBean> query = entityManager.createQuery("SELECT d FROM DonorBean d", DonorBean.class);
		return query.getResultList();
	}
	
}
