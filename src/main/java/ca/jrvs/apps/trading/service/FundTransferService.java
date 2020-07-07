package ca.jrvs.apps.trading.service;


import ca.jrvs.apps.trading.web.resources.AccountWebResponse;

public interface FundTransferService {
    AccountWebResponse deposit(Integer traderId, Double fund);
    AccountWebResponse withdraw(Integer traderId, Double fund);
}
