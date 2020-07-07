package ca.jrvs.apps.trading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TradingInteractionApplication {
    private Logger logger = LoggerFactory.getLogger(TradingInteractionApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TradingInteractionApplication.class, args);
    }

}
