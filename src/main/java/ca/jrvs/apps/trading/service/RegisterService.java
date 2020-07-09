package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.generated.trading.model.TraderRequest;
import ca.jrvs.apps.trading.web.resources.TraderProfileWebResponse;

public interface RegisterService {

    TraderProfileWebResponse createTraderAndAccount(TraderRequest req);

    void deleteTraderById(Integer traderId);
}
