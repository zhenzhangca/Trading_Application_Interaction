package ca.jrvs.apps.trading.web.resources;

import ca.jrvs.apps.generated.trading.model.SecurityRow;
import lombok.*;

import java.util.List;

@Getter
@Setter
//@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioWebResponse {
    private List<SecurityRow> securityRows;
}
