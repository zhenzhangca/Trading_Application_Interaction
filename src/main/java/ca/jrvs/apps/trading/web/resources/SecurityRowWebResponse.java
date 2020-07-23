package ca.jrvs.apps.trading.web.resources;

import ca.jrvs.apps.trading.generated.shared.model.Position;
import ca.jrvs.apps.trading.generated.shared.model.Quote;
import lombok.*;

@Getter
@Setter
//@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityRowWebResponse {
    private Position position;
    private Quote quote;
    private String ticker;
}
