package in.flex.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.flex.dto.Quote;
import in.flex.dto.QuoteResponse;

@Controller
public class QuoteController {
	@GetMapping("/quotes")
	public String getQuotes(Model model) throws JsonMappingException, JsonProcessingException {
	    String apiUrl = "https://dummyjson.com/quotes";
	    RestTemplate template = new RestTemplate();
	    ResponseEntity<String> forEntity = template.getForEntity(apiUrl, String.class);
	    String body = forEntity.getBody();
	    System.out.println(body);
	    
	    // Create an ObjectMapper instance
	    ObjectMapper mapper = new ObjectMapper();
	    
	    // Define a wrapper class to map the response
	   

	    // Deserialize the JSON into the QuoteResponse class
	    QuoteResponse quoteResponse = mapper.readValue(body, QuoteResponse.class);
	    
	    // Get the list of quotes
	    List<Quote> list = quoteResponse.quotes;

	    // Add quotes to the model
	    model.addAttribute("quotes", list);
	    
	    return "quotesfile";
	}
}
