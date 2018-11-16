package br.com.abim.primo;

import br.com.abim.primo.domain.Greeter;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;



import org.junit.Test;

public class HelloWorldTest {

	private Greeter greeter = new Greeter();

	@Test
	public void greeterSaysHello() {
		assertThat(greeter.sayHello(), containsString("Hello"));
	}

	@Test
	public void greeterShowLocalTime() {
		assertThat(greeter.showLocalTime(), containsString("The current"));
	}
	
	
}