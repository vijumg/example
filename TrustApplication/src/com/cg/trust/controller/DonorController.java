package com.cg.trust.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.trust.beans.DonorBean;
import com.cg.trust.service.IDonorService;

@Controller
public class DonorController {
	
	@Autowired
	private IDonorService donorService;
	
	public IDonorService getDonorService() {
		return donorService;
	}

	public void setDonorService(IDonorService donorService) {
		this.donorService = donorService;
	}

	@RequestMapping("/showHomePage")
	public String showHomePage() {
		return "index";
	}

	@RequestMapping("/showAddDonationForm")
	public ModelAndView showAddDonation() {
		// Create an attribute of type Question
		DonorBean donor = new DonorBean();
		// Add the attribute to the model and set the viewname and return it
		return new ModelAndView("addDonationForm", "donor", donor);
	}

	@RequestMapping("/addDonation")
	public ModelAndView addDonation(
			@ModelAttribute("donor") @Valid DonorBean donor,
			BindingResult result) {

		ModelAndView mv = null;

		if (!result.hasErrors()) {
			donor = donorService.addDonation(donor);
			mv = new ModelAndView("addSuccess");
			mv.addObject("donorId", donor.getDonorId());
			mv.addObject("amount", donor.getDonationAmount());
		} else {
			mv = new ModelAndView("addDonationForm", "donor", donor);
		}

		return mv;
	}

	@RequestMapping("/showViewDonationForm")
	public ModelAndView showViewDonationForm() {

		// Create an attribute of type Question
		DonorBean donor = new DonorBean();
		// Add the attribute to the model and return along with
		// the view name
		ModelAndView mv = new ModelAndView("viewDonation");
		mv.addObject("donor", donor);
		mv.addObject("isFirst", "true");

		return mv;
	}

	@RequestMapping("/viewDonation")
	public ModelAndView viewDonation(@ModelAttribute("donor") DonorBean donor) {

		ModelAndView mv = new ModelAndView();

		DonorBean dBean = new DonorBean();
		dBean = donorService.getDonationDetails(donor.getDonorId());

		if (dBean != null) {
			mv.setViewName("viewDonation");
			mv.addObject("dBean", dBean);
		} else {
			String msg = "Enter a Valid Id!!";
			mv.setViewName("myError");
			mv.addObject("msg", msg);
		}

		return mv;
	}

	@RequestMapping("/showViewAllDonations")
	public ModelAndView showViewAllDonations() {

		ModelAndView mv = new ModelAndView();

		List<DonorBean> list = donorService.getAllDonorsDetails();
		if (list.isEmpty()) {
			String msg = "There are no Donors";
			mv.setViewName("myError");
			mv.addObject("msg", msg);
		} else {
			mv.setViewName("viewAllDonorsList");
			// Add the attribute to the model
			mv.addObject("list", list);
		}
		return mv;
	}
}
