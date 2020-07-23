package ca.jrvs.apps.trading.web;

import ca.jrvs.apps.trading.service.ActivityService;
import ca.jrvs.apps.trading.util.ResponseExceptionUtil;
import ca.jrvs.apps.trading.web.resources.ActivityWebResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api/v1/audit")
@Api(value = "activity")
@Slf4j
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping(path = "/activity", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Show the list of activity", notes = "Show the list of activity.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, responseContainer = "List", response = ActivityWebResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request completes successfully."),
            @ApiResponse(code = 404, message = "Not found."),
            @ApiResponse(code = 500, message = "Internal Server Error.")
    })
    public ResponseEntity<?> getActivityList() {
        try {
            List<ActivityWebResponse> responses = activityService.getActivityList();
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(responses);
        } catch (Exception e) {
            throw ResponseExceptionUtil.getResponseStatusException(e);
        }
    }
}
