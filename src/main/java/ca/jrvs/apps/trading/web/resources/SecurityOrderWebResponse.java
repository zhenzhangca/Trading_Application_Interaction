package ca.jrvs.apps.trading.web.resources;

import lombok.*;

@Getter
@Setter
//@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityOrderWebResponse {

    private Integer id;
    private Integer accountId;
    private String status;
    private String ticker;
    private String notes;
    private Double price;
    private Integer size;
}
