package in.vistara.service;

import java.util.List;

import in.vistara.dto.Quote;

public interface IQuoteService {
public abstract List<Quote> getQuotes() throws Exception; 
}