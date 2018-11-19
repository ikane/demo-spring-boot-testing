package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@DataMongoTest
@RunWith(SpringRunner.class)
public class ReservationRepositoryTest {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	private final Reservation one = new Reservation(null, "Francois");
	private final Reservation two = new Reservation(null, "Marie Jeanne");
	
	@Test
	public void getAllReservations() throws Exception {
		
		//this.reservationRepository.deleteAll().;
		
		Flux<Reservation> saved = Flux.just(this.one, this.two)
				.flatMap(this.reservationRepository::save);
		
		StepVerifier
			.create(saved.thenMany(this.reservationRepository.findByReservationName("Francois")))
			.expectNextMatches(r -> r.getReservationName().equalsIgnoreCase(this.one.getReservationName()))
			.verifyComplete();
	}

}
