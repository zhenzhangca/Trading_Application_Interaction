package ca.jrvs.apps.trading.web.resources;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityWebResponse {

    private Integer id;
    private String activity;
    private String desc;

}
