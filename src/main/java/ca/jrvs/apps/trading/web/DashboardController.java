package ca.jrvs.apps.trading.web;

import ca.jrvs.apps.trading.service.DashboardService;
import ca.jrvs.apps.trading.util.ResponseExceptionUtil;
import ca.jrvs.apps.trading.web.resources.PortfolioWebResponse;
import ca.jrvs.apps.trading.web.resources.TraderProfileWebResponse;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(value = "/api/v1/trading/dashboard")
@Api(value = "dashboard")
@Slf4j
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping(path = "/portfolio/traderId/{traderId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Show portfolio by trader ID", notes = "Show portfolio by trader ID.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, response = PortfolioWebResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request completes sucessfully."),
            @ApiResponse(code = 404, message = "Not found."),
            @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    public ResponseEntity<?> getPortfolioById(
            @ApiParam(value = "Trader ID")
            @PathVariable Integer traderId) {
        try {
            PortfolioWebResponse response = dashboardService.getPortfolioByTraderId(traderId);
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(response);
        } catch (Exception e) {
            throw ResponseExceptionUtil.getResponseStatusException(e);
        }
    }

    @GetMapping(path = "/profile/traderId/{traderId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Show trader's profile by trader ID", notes = "Show trader's profile by trader ID.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, response = TraderProfileWebResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request completes sucessfully."),
            @ApiResponse(code = 404, message = "Not found."),
            @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    public ResponseEntity<?> getTraderProfileById(
            @ApiParam(value = "Trader ID")
            @PathVariable Integer traderId) {
        try {
            TraderProfileWebResponse response = dashboardService.getTraderProfile(traderId);
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(response);
        } catch (Exception e) {
            throw ResponseExceptionUtil.getResponseStatusException(e);
        }
    }
}
