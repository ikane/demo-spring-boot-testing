package com.example.demo;


import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ReservationPojoTest {

	@Test
	public void create() throws Exception {
		
		Reservation reservation = new Reservation("1", "Jane");
		
		Assertions.assertThat(reservation.getId()).isEqualTo("1");
		Assertions.assertThat(reservation.getReservationName()).isEqualTo("Jane");
	}

}
