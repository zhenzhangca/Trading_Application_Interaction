package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.generated.shared.model.TraderRequest;
import ca.jrvs.apps.trading.web.resources.TraderProfileWebResponse;

public interface RegisterService {

    TraderProfileWebResponse createTraderAndAccount(TraderRequest req);

    void deleteTraderById(Integer traderId);
}
