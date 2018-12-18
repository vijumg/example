package com.cg.btva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.btva.bean.BusBean;
import com.cg.btva.dao.IBusDao;

@Service
public class BusServiceImpl implements IBusService {
	@Autowired
	/*
	 * Dao object creation
	 */
	IBusDao busDao;

	public IBusDao getBusDao() {
		return busDao;
	}

	public void setBusDao(IBusDao busDao) {
		this.busDao = busDao;
	}

	@Override
	public List<BusBean> getAllBusDetails() {
		return busDao.getAllBusDetails();
	}

}
