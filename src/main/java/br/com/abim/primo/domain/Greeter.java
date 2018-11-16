package br.com.abim.primo.domain;

import org.joda.time.LocalTime;

public class Greeter {
	public String sayHello() {
		return "Hello world! How are you?";
	}

	public String showLocalTime() {
		LocalTime currentTime = new LocalTime();
		return "The current local time is: " + currentTime;
	}
}