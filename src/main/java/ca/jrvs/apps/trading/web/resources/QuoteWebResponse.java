package ca.jrvs.apps.trading.web.resources;

import lombok.*;

@Getter
@Setter
//@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteWebResponse {
    private String ticker;
    private Double askPrice;
    private Integer askSize;
    private Double bidPrice;
    private Integer bidSize;
    private Double lastPrice;
}
