package ca.jrvs.apps.trading.web;

import ca.jrvs.apps.generated.trading.model.TraderRequest;
import ca.jrvs.apps.trading.service.FundTransferService;
import ca.jrvs.apps.trading.service.RegisterService;
import ca.jrvs.apps.trading.util.ResponseExceptionUtil;
import ca.jrvs.apps.trading.web.resources.AccountWebResponse;
import ca.jrvs.apps.trading.web.resources.TraderProfileWebResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(value = "trader", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Controller
@RequestMapping("/trader")
public class TraderController {
    @Autowired
    private FundTransferService fundTransferService;
    @Autowired
    private RegisterService registerService;


    @DeleteMapping(path = "/traderId/{traderId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Delete a trader", notes = "Delete a trader IFF its account amount is 0 and no open positions. Also delete the associated account and securityOrders.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request completes successfully."),
//            @ApiResponse(code = 404, message = "Not found."),
            @ApiResponse(code = 400, message = "Unable to delete the trader."),
            @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    public ResponseEntity<?> deleteTrader(
            @ApiParam(value = "Trader ID")
            @PathVariable Integer traderId) {
        try {
            registerService.deleteTraderById(traderId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw ResponseExceptionUtil.getResponseStatusException(e);
        }
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Create a trader and an account", notes = "TraderId and AccountId are auto generated by the database, and they should be identical. Assume each trader has exact one account.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, response = TraderProfileWebResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request completes successfully."),
            @ApiResponse(code = 404, message = "Not found."),
            @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    public ResponseEntity<?> createTrader(
            @ApiParam(value = "Trader Request", format = "yyyy-MM-dd")
            @RequestBody TraderRequest req) {
        try {
            TraderProfileWebResponse response = registerService.createTraderAndAccount(req);
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(response);
        } catch (Exception e) {
            throw ResponseExceptionUtil.getResponseStatusException(e);
        }
    }

    @PutMapping(path = "/deposit/traderId/{traderId}/amount/{amount}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Deposit a fund", notes = "Deposit a fund to the account that associates with the given traderId. Deposit amount must be greater than 0.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, response = AccountWebResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request completes successfully."),
            @ApiResponse(code = 404, message = "TraderId is not found."),
            @ApiResponse(code = 400, message = "Unable to deposit due to user input"),
            @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    public ResponseEntity<?> depositFund(
            @ApiParam(value = "Fund amount")
            @PathVariable Double amount,
            @ApiParam(value = "Trader ID")
            @PathVariable Integer traderId) {
        try {
            AccountWebResponse response = fundTransferService.deposit(traderId, amount);
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(response);
        } catch (Exception e) {
            throw ResponseExceptionUtil.getResponseStatusException(e);
        }
    }

    @PutMapping(path = "/withdraw/traderId/{traderId}/amount/{amount}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Withdraw a fund", notes = "Withdraw a fund from the account that associates with the given traderId. Withdraw amount must not exceed account amount.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, response = AccountWebResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request completes successfully."),
            @ApiResponse(code = 404, message = "TraderId is not found."),
            @ApiResponse(code = 400, message = "Unable to withdraw due to user input (e.g. insufficient funds)"),
            @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    public ResponseEntity<?> withdrawFund(
            @ApiParam(value = "Fund amount")
            @PathVariable Double amount,
            @ApiParam(value = "Trader ID")
            @PathVariable Integer traderId) {
        try {
            AccountWebResponse response = fundTransferService.withdraw(traderId, amount);
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(response);
        } catch (Exception e) {
            throw ResponseExceptionUtil.getResponseStatusException(e);
        }
    }
}
