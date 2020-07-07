package ca.jrvs.apps.trading.service.impl;

import ca.jrvs.apps.trading.service.OrderService;
import ca.jrvs.apps.trading.web.resources.MarketOrderWebRequest;
import ca.jrvs.apps.trading.web.resources.SecurityOrderWebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("OrderServiceImpl")
@Slf4j
public class OrderServiceImpl implements OrderService {


    public SecurityOrderWebResponse addMarketOrder(MarketOrderWebRequest req) {
        return null;

    }

}
