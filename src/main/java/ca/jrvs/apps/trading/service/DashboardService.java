package ca.jrvs.apps.trading.service;


import ca.jrvs.apps.trading.web.resources.PortfolioWebResponse;
import ca.jrvs.apps.trading.web.resources.TraderProfileWebResponse;

public interface DashboardService {

    PortfolioWebResponse getPortfolioByTraderId(Integer traderId);

    TraderProfileWebResponse getTraderProfile(Integer traderId);
}
