package ca.jrvs.apps.trading.web.resources;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
//@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraderWebRequest {

//    private Integer id;  //generated automatically
    private String country;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp dob;
    private String email;
    private String firstName;
    private String lastName;
}