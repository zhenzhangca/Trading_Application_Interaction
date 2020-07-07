package ca.jrvs.apps.trading.web.resources;

import lombok.*;

@Getter
@Setter
//@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountWebResponse {

    private Integer id;
    private Double amount;
    private Integer traderId;
}
