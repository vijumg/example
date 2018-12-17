package com.cg.trust.service;

import java.util.List;

import com.cg.trust.beans.DonorBean;

public interface IDonorService 
{

	public DonorBean addDonation(DonorBean donor);
	public DonorBean getDonationDetails(int donorId);
	public List<DonorBean> getAllDonorsDetails();
	
}
