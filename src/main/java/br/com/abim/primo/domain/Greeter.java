package br.com.abim.primo.domain;

import org.joda.time.LocalTime;

public class Greeter {
	public String sayHello() {
		return "Olá como vai você?";
	}

	public String showLocalTime() {
		LocalTime currentTime = new LocalTime();
		return "The current local time is: " + currentTime;
	}
	
}