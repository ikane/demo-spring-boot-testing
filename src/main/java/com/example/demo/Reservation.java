package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
	
	private String id;
	private String reservationName;
	
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}


	public Reservation(String id, String reservationName) {
		super();
		this.id = id;
		this.reservationName = reservationName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getReservationName() {
		return reservationName;
	}


	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	
	
	
	

}
