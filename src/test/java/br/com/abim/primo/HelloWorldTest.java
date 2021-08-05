package br.com.abim.primo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.abim.primo.domain.Greeter;

public class HelloWorldTest {

	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertThat(greeter.sayHello(), containsString("como vai"));
	}

	@Test
	public void greeterShowLocalTime() {
		assertThat(greeter.showLocalTime(), containsString("The current"));
	}

	
}