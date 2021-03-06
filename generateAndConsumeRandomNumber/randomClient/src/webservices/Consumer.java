package webservices;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class Consumer {

	public static void main(String[] args) throws InterruptedException {
		//servico
		RandomService randomService = new RandomService();
		
		//proxy
		Random proxy = randomService.getRandomPort();
		
		//o cliente do serviço deve adicionar as informacoes necessarias para autenticacao nos headers da requisicao HTTP
		BindingProvider bp = (BindingProvider) proxy;
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList("k19"));
		headers.put("Password", Collections.singletonList("k23"));
		bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		//operacao
		double next = proxy.next(10);
		
		System.out.println(next);		
	}
}