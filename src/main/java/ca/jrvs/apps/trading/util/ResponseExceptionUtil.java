package ca.jrvs.apps.trading.util;

import ca.jrvs.apps.trading.excptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ResponseExceptionUtil {
    private static final Logger logger = LoggerFactory.getLogger(ResponseExceptionUtil.class);

    public static ResponseStatusException getResponseStatusException(Exception ex) {
        if (ex instanceof IllegalArgumentException) {
            logger.debug("Invalid put", ex);
            return new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());//400 user side wrong
        } else if (ex instanceof ResourceNotFoundException) {
            logger.debug("Not found", ex);
            return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());//404
        } else {
            logger.error("Internal Error", ex);
            return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Internal Error: please contact admin");  //500
        }
    }
}
