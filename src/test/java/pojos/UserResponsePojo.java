package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponsePojo {
    private String id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
