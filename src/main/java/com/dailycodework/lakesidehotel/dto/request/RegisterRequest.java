package com.dailycodework.lakesidehotel.dto.request;

import com.dailycodework.lakesidehotel.model.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "first name can not be null")
    private String firstname;
    @NotBlank(message = "last name can not be null")
    private String lastname;
    @NotBlank(message = "email ca not be null")
    private String email;
    @NotBlank(message = "password can not be null")
    private String password;
    private List<Role> roles;
}
