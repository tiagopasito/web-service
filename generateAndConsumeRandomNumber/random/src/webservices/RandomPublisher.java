package webservices;

import javax.xml.ws.Endpoint;

public class RandomPublisher {

	public static void main(String[] args) {
		
		System.out.println("Random web service start...");
		Random random = new Random();
	
		//publica o servico
		Endpoint.publish("http://localhost:8080/random", random );	
	}
}