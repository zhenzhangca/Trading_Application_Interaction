package ca.jrvs.apps.trading.service.impl;

import ca.jrvs.apps.generated.trading.ApiClient;
import ca.jrvs.apps.generated.trading.api.TraderControllerApi;
import ca.jrvs.apps.generated.trading.model.TraderProfileResponse;
import ca.jrvs.apps.generated.trading.model.TraderRequest;
import ca.jrvs.apps.trading.excptions.ResourceNotFoundException;
import ca.jrvs.apps.trading.service.RegisterService;
import ca.jrvs.apps.trading.web.resources.TraderProfileWebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private TraderControllerApi traderControllerApi;

    /**
     * Create a new trader and initialize a new account with 0 amount.
     * - validate user input (all fields must be non empty)
     * - create a trader
     * - create an account
     * - create, setup, and return a new traderAccountView
     *
     * @param req trader info
     * @return traderAccountView
     * @throws ResourceNotFoundException                   if ticker is not found from IEX
     * @throws org.springframework.dao.DataAccessException if unable to retrieve data
     * @throws IllegalArgumentException                    for invalid input
     */
    public TraderProfileWebResponse createTraderAndAccount(TraderRequest req) {
        TraderProfileResponse traderProfileResponse = traderControllerApi.createTraderAndAccountUsingPOST(req);
        return convertTraderProfileResponse(traderProfileResponse);
    }

    private TraderProfileWebResponse convertTraderProfileResponse(TraderProfileResponse model) {
        return TraderProfileWebResponse.builder()
                .account(model.getAccount())
                .trader(model.getTrader())
                .build();
    }

    /**
     * A trader can be deleted iff no open position and no cash balance.
     * - validate traderID
     * - get trader account by traderId and check account balance
     * - get positions by accountId and check positions
     * - delete all securityOrders, account, trader (in this order)
     *
     * @param traderId
     * @throws ResourceNotFoundException                   if ticker is not found from IEX
     * @throws org.springframework.dao.DataAccessException if unable to retrieve data
     * @throws IllegalArgumentException                    for invalid input
     */
    public void deleteTraderById(Integer traderId) {
        traderControllerApi.deleteTraderUsingDELETE(traderId);

    }
}