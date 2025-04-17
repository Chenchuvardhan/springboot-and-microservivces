package in.vistara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.vistara.dto.Quote;
import in.vistara.service.IQuoteService;

@Controller
public class QuoteController {
	@Autowired
	private IQuoteService quoteService;

	@GetMapping(value = "/response")
	public String getQuoteResponse(Model model) throws Exception {
		List<Quote> quotes = quoteService.getQuotes();
		model.addAttribute("quotes", quotes);
		return "quotes";
	}
}
