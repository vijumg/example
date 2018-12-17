package com.cg.trust.dao;

import java.util.List;

import com.cg.trust.beans.DonorBean;

public interface IDonorDao {
	public DonorBean addDonation(DonorBean donor);
	public DonorBean getDonationDetails(int donorId);
	public List<DonorBean> getAllDonorsDetails();	
}
