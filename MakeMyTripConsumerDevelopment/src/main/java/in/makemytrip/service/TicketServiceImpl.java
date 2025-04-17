package in.makemytrip.service;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.makemytrip.dto.Ticket;
import reactor.core.publisher.Mono;
@Service
public class TicketServiceImpl implements ITicketService {

	@Override
	public List<Ticket> getTickets() throws Exception {
		// TODO Auto-generated method stub
		String apiUrl="https://www.classes.ashokit.in/tickets";
		WebClient webClient = WebClient.create();
		Mono<String> bodyToMono = webClient.get()
		         .uri(apiUrl)
		         .retrieve()
		         .bodyToMono(String.class);
				String block = bodyToMono.block();
				ObjectMapper mapper=new ObjectMapper();
			    List<Ticket> list = mapper.readValue(block,new TypeReference<List<Ticket>>(){});
		return list;
	}

	@Override
	public Ticket saveTicket(Ticket ticket) throws Exception {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writeValueAsString(ticket);
		String apiUrl="https://www.classes.ashokit.in/ticket";
		WebClient webClient = WebClient.create();
		Mono<String> bodyToMono = webClient.post()
		         .uri(apiUrl)
		         .contentType(MediaType.APPLICATION_JSON)
		         .bodyValue(writeValueAsString)
		         .retrieve()
		         .bodyToMono(String.class);
	//	String block = bodyToMono.block();
		//Ticket value = objectMapper.readValue(block, Ticket.class);
		
		  
		  return objectMapper.readValue(bodyToMono.block(), Ticket.class); //return value;
		 
	}

}
