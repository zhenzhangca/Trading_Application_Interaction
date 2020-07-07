package ca.jrvs.apps.trading.web.resources;

import ca.jrvs.apps.generated.trading.model.Position;
import ca.jrvs.apps.generated.trading.model.Quote;
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
