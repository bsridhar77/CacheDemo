package com.poc.cache.quote.dao;

import java.util.Collection;

import com.poc.quote.model.Quote;

public interface QuoteCacheDAO {

	Quote getQuoteByQuoteId(String quoteId);
	
	Collection<Quote> getQuoteByAgentId(String agentId);
	
	Collection<Quote> getQuoteByQuoteTypeAndAgentId(String quoteType,String agentId);
	
	Collection<Quote> getQuoteByQuoteStatusAndAgentId(String quoteStatus,String agentId);
	
	
}
