package br.com.abim.primo.main;


import br.com.abim.primo.domain.Greeter;

public class HelloWorld {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
		System.out.println(greeter.showLocalTime());
		
	}
	
}