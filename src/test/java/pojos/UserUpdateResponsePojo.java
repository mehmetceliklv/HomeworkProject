package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserUpdateResponsePojo {

    private String email;
    private String name;
    private String gender;
    private String status;
    private String id;
}
