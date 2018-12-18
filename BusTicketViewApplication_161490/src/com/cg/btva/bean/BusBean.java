package com.cg.btva.bean;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "busdetails")
public class BusBean {

	@Id
	private int busId;
	private String busTravelName;
	private String source;
	private String destination;
	private int availableSeats;

	public BusBean(int busId, String busTravelName, String source,
			String destination, int availableSeats) {
		super();
		this.busId = busId;
		this.busTravelName = busTravelName;
		this.source = source;
		this.destination = destination;
		this.availableSeats = availableSeats;
	}

	public BusBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusTravelName() {
		return busTravelName;
	}

	public void setBusTravelName(String busTravelName) {
		this.busTravelName = busTravelName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

}
