package com.example.demo;

import java.util.function.Predicate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@DataMongoTest
@RunWith(SpringRunner.class)
public class ReservationDocumentTest {
	
	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;
	
	private final Reservation one = new Reservation(null, "Mario");
	private final Reservation two = new Reservation(null, "Makami");
	
	@Test
	public void persist() throws Exception {
		
		Flux<Reservation> reservationFlux = Flux.just(this.one, this.two);
		Flux<Reservation> saved = reservationFlux.flatMap(this.reactiveMongoTemplate::save);
		
		Predicate<Reservation> predicate = (Reservation r) -> StringUtils.hasText(r.getReservationName()) 
																&& StringUtils.hasText(r.getId()) ;
		
		StepVerifier
			.create(saved)
			.expectNextMatches(predicate)
			.expectNextMatches(predicate)
			.verifyComplete();
	}

}
