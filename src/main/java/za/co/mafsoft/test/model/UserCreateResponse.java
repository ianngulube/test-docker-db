package za.co.mafsoft.test.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCreateResponse {
    private String description;
    private String email;
}
