package com.cg.trust.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.trust.beans.DonorBean;
import com.cg.trust.dao.IDonorDao;

@Service
public class DonorService implements IDonorService
{

	@Autowired
	IDonorDao donorDao;

	
	
	public IDonorDao getDonorDao() {
		return donorDao;
	}

	public void setDonorDao(IDonorDao donorDao) {
		this.donorDao = donorDao;
	}

	@Override
	public DonorBean addDonation(DonorBean donor) {
		//set todays date as donation date		
		donor.setDonationDate(new Date());
		return donorDao.addDonation(donor);
	}

	@Override
	public DonorBean getDonationDetails(int donorId) {
		return donorDao.getDonationDetails(donorId);
	}

	@Override
	public List<DonorBean> getAllDonorsDetails() {
		return donorDao.getAllDonorsDetails();
	}

	}
