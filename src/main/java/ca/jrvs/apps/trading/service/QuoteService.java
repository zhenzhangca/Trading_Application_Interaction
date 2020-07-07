package ca.jrvs.apps.trading.service;


import ca.jrvs.apps.generated.trading.model.Quote;
import ca.jrvs.apps.trading.web.resources.IexQuoteWebResponse;
import ca.jrvs.apps.trading.web.resources.QuoteWebResponse;

import java.util.List;

//@Transactional
public interface QuoteService {

    List<QuoteWebResponse> updateMarketData() throws Exception;

    IexQuoteWebResponse findIexQuoteByTicker(String ticker) throws Exception;

    List<QuoteWebResponse> getDailyList();

    QuoteWebResponse update(Quote quote);

    void initQuote(String ticker) throws Exception;

}

