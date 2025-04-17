package in.cipla.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.cipla.entity.Quote;

@RestController
public class TemplateController {
	@GetMapping(value = "/getquote",
			    produces = "application/json" 
			   )
	public ResponseEntity<List<Quote>> getQuote() throws Exception {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> forEntity = rt.getForEntity("https://dummyjson.com/quotes/random", String.class);
		String body = forEntity.getBody();
		System.out.println(body);
		ObjectMapper objectMapper = new ObjectMapper();
		Quote value = objectMapper.readValue(body, Quote.class);
		//
		RestTemplate temp = new RestTemplate();
		ResponseEntity<String> forEntity2 = temp.getForEntity("https://dummyjson.com/quotes", String.class);
		String body2 = forEntity2.getBody();
		System.out.println(body2);

		// Assuming the response is a JSON object with a "quotes" field containing the list
		Map<String, Object> responseMap = objectMapper.readValue(body2, new TypeReference<Map<String, Object>>() {});
		List<Quote> value2 = (List<Quote>) responseMap.get("quotes");

		// Return the response as a List<Quote>
		return new ResponseEntity<List<Quote>>(value2, HttpStatus.OK);

		
	}
}
