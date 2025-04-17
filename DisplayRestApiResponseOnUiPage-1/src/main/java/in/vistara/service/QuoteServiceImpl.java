package in.vistara.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.vistara.dto.Quote;
import in.vistara.dto.QuoteBody;
@Service
public class QuoteServiceImpl implements IQuoteService {

	@Override
	public List<Quote> getQuotes()throws Exception {
		//url
		String providerUrl="https://dummyjson.com/quotes";
		//accessing rest api through predefined resttemplate class
		RestTemplate rstplt=new RestTemplate();
        ResponseEntity<String> forEntity = rstplt.getForEntity(providerUrl,String.class);
        String body = forEntity.getBody();
        System.out.println(body);
        ObjectMapper mapper=new ObjectMapper();
        QuoteBody value = mapper.readValue(body,QuoteBody.class);
		List<Quote> list=value.quotes;
		System.out.println(list);
		return list;
	}

}
