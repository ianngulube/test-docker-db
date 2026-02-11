package za.co.mafsoft.test.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record GetUserRequest(@NotBlank @Email String email) {
}
