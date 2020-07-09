package ca.jrvs.apps.trading.service.impl;

import ca.jrvs.apps.generated.trading.api.DashboardControllerApi;
import ca.jrvs.apps.generated.trading.model.PortfolioResponse;
import ca.jrvs.apps.generated.trading.model.TraderProfileResponse;
import ca.jrvs.apps.trading.excptions.ResourceNotFoundException;
import ca.jrvs.apps.trading.service.DashboardService;
import ca.jrvs.apps.trading.web.resources.PortfolioWebResponse;
import ca.jrvs.apps.trading.web.resources.TraderProfileWebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service("DashBoardServiceImpl")
@Slf4j
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private DashboardControllerApi dashboardControllerApi;

    /**
     * Create and return a trader profile by trader ID
     * - get trader account by id
     * - get trader info by id
     * - create and return a traderAccountView
     *
     * @param traderId trader ID
     * @return traderAccountView
     * @throws ResourceNotFoundException if ticker is not found from IEX
     * @throws DataAccessException       if unable to retrieve data
     * @throws IllegalArgumentException  for invalid input
     */

    public TraderProfileWebResponse getTraderProfile(Integer traderId) {
        TraderProfileResponse traderProfileResponse = dashboardControllerApi.getTraderProfileByIdUsingGET(traderId);
        return convertTraderProfileResponse(traderProfileResponse);
    }

    private TraderProfileWebResponse convertTraderProfileResponse(TraderProfileResponse model) {
        return TraderProfileWebResponse.builder()
                .trader(model.getTrader())
                .account(model.getAccount())
                .build();
    }


    /**
     * Create and return portfolioView by trader ID
     * - get account by trader id
     * - get positions by account id
     * - create and return a portfolioView
     *
     * @param traderId
     * @return portfolioView
     * @throws ResourceNotFoundException if ticker is not found from IEX
     * @throws DataAccessException       if unable to retrieve data
     * @throws IllegalArgumentException  for invalid input
     */
    public PortfolioWebResponse getPortfolioByTraderId(Integer traderId) {
        PortfolioResponse portfolioResponse = dashboardControllerApi.getPortfolioByIdUsingGET(traderId);
        return covertPortFolioResponse(portfolioResponse);
    }

    private PortfolioWebResponse covertPortFolioResponse(PortfolioResponse model) {
        return PortfolioWebResponse.builder()
                .securityRows(model.getSecurityRows())
                .build();
    }

}
