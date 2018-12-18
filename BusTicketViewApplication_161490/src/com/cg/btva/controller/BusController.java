package com.cg.btva.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.btva.bean.BusBean;
import com.cg.btva.exception.IDExistsException;
import com.cg.btva.service.IBusService;




@Controller
public class BusController {
	@Autowired
	/*
	 * service object creation
	 */
	private IBusService service;

	public IBusService getService() {
		return service;
	}

	public void setService(IBusService service) {
		this.service = service;
	}
	
	/*
	 * RequestMapping for the operation page 
	 */
	@RequestMapping("/showHomePage")
	public String showHomePage() {
		return "operation";
	}
	
	/*
	 * RequestMapping to get all the details from data base
	 */
	

	@RequestMapping("/retrieveallForms")
	public ModelAndView viewBusDetails() throws IDExistsException
	{
		ModelAndView view = new ModelAndView();
		List<BusBean> list= service.getAllBusDetails();
		if(list.isEmpty())
		{
			throw new IDExistsException("*****OOPss!!!!! NO DATA*****");
		}
		else
		{
			view.setViewName("busDetails");
			view.addObject("list",list);
		}
		System.out.println(list);
		return view;
	}
}
