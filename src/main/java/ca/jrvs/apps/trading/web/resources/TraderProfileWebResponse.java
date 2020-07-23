package ca.jrvs.apps.trading.web.resources;

import ca.jrvs.apps.trading.generated.shared.model.Account;
import ca.jrvs.apps.trading.generated.shared.model.Trader;
import lombok.*;

@Getter
@Setter
//@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraderProfileWebResponse {
    private Account account;
    private Trader trader;
}
