package ca.jrvs.apps.trading.service.impl;

import ca.jrvs.apps.trading.excptions.ResourceNotFoundException;
import ca.jrvs.apps.trading.service.FundTransferService;
import ca.jrvs.apps.trading.web.resources.AccountWebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FundTransferServiceImpl implements FundTransferService {

    /**
     * Deposit a fund to the account which is associated with the traderId
     * - validate user input
     * - account = accountDao.findByTraderId
     * - accountDao.updateAmountById
     *
     * @param traderId trader id
     * @param fund     found amount (can't be 0)
     * @return updated Account object
     * @throws ResourceNotFoundException                   if ticker is not found from IEX
     * @throws org.springframework.dao.DataAccessException if unable to retrieve data
     * @throws IllegalArgumentException                    for invalid input
     */
    public AccountWebResponse deposit(Integer traderId, Double fund) {

        return null;
    }


    /**
     * Withdraw a fund from the account which is associated with the traderId
     * <p>
     * - validate user input
     * - account = accountDao.findByTraderId
     * - accountDao.updateAmountById
     *
     * @param traderId trader ID
     * @param fund     amount can't be 0
     * @return updated Account object
     * @throws ResourceNotFoundException if ticker is not found from IEX
     * @throws org.springframework.dao.DataAccessException        if unable to retrieve data
     * @throws IllegalArgumentException                           for invalid input
     */
    public AccountWebResponse withdraw(Integer traderId, Double fund) {
        return null;
    }


}
