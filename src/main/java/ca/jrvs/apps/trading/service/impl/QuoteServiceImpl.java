package ca.jrvs.apps.trading.service.impl;

import ca.jrvs.apps.generated.trading.model.Quote;
import ca.jrvs.apps.trading.excptions.ResourceNotFoundException;
import ca.jrvs.apps.trading.service.QuoteService;
import ca.jrvs.apps.trading.web.resources.IexQuoteWebResponse;
import ca.jrvs.apps.trading.web.resources.QuoteWebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("QuoteServiceImpl")
@Slf4j
public class QuoteServiceImpl implements QuoteService {

    /**
     * Helper method. Map a IexQuote to a Quote entity.
     * Note: `iexQuote.getLatestPrice() == null` if the stock market is closed.
     * Make sure set a default value for number field(s).
     */
//    public Quote convertQuoteFromIexQuote(IexQuote iexQuote) {
//return null;
//    }

    /**
     * Add a list of new tickers to the quote table. Skip existing ticker(s).
     * - Get iexQuote(s)
     * - convert each iexQuote to Quote entity
     * - persist the quote to db
     *
     * @param tickers a list of tickers/symbols
     * @throws ResourceNotFoundException                   if ticker is not found from IEX
     * @throws org.springframework.dao.DataAccessException if unable to retrieve data
     * @throws IllegalArgumentException                    for invalid input
     */
    public void initQuotes(List<String> tickers) throws Exception {

    }

    /**
     * Add a new ticker to the quote table. Skip existing ticker.
     *
     * @param ticker ticker/symbol
     * @throws ResourceNotFoundException                   if ticker is not found from IEX
     * @throws org.springframework.dao.DataAccessException if unable to retrieve data
     * @throws IllegalArgumentException                    for invalid input
     */
    public void initQuote(String ticker) throws Exception {
        initQuotes(Collections.singletonList(ticker));
    }

    /**
     * Update quote table against IEX source
     * - get all quotes from the db
     * - foreach ticker get iexQuote
     * - convert iexQuote to quote entity
     * - persist quote to db
     *
     * @throws ResourceNotFoundException                   if ticker is not found from IEX
     * @throws org.springframework.dao.DataAccessException if unable to retrieve data
     * @throws IllegalArgumentException                    for invalid input
     */
    public List<QuoteWebResponse> updateMarketData() throws Exception {

        return null;
    }

    private QuoteWebResponse convertQuote(Quote model) {
        return null;
    }

    public IexQuoteWebResponse findIexQuoteByTicker(String ticker) throws Exception {
       return null;
    }


    public List<QuoteWebResponse> getDailyList() {

        return null;
    }

    public QuoteWebResponse update(Quote quote) {

        return null;
    }

}
