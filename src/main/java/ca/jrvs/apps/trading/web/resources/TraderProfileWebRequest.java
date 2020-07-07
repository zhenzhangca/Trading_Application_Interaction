package ca.jrvs.apps.trading.web.resources;

import ca.jrvs.apps.generated.trading.model.Account;
import ca.jrvs.apps.generated.trading.model.Trader;
import lombok.*;

@Getter
@Setter
//@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraderProfileWebRequest {
    private Account account;
    private Trader trader;
}
