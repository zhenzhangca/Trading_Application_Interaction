package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.web.resources.TraderProfileWebResponse;
import ca.jrvs.apps.trading.web.resources.TraderWebRequest;

public interface RegisterService {

    TraderProfileWebResponse createTraderAndAccount(TraderWebRequest req);

    void deleteTraderById(Integer traderId);
}
