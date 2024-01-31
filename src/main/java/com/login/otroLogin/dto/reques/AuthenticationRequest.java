package com.login.otroLogin.dto.reques;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

    @NotBlank(message = "Debe ingresar su username")
    private String username;

    @NotBlank(message = "Debe ingresar su contraseña")
    private String password;
}
