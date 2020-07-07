package ca.jrvs.apps.trading.service;


import ca.jrvs.apps.trading.web.resources.MarketOrderWebRequest;
import ca.jrvs.apps.trading.web.resources.SecurityOrderWebResponse;

public interface OrderService {
    SecurityOrderWebResponse addMarketOrder(MarketOrderWebRequest req);
}
