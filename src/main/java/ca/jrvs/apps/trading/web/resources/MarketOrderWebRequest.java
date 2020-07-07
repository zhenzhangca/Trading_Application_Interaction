package ca.jrvs.apps.trading.web.resources;

import lombok.*;

@Getter
@Setter
//@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketOrderWebRequest {

    private Integer accountId;
    private Integer size;
    private String ticker;
    private String notes;
}
