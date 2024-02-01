package com.login.otroLogin.service.iface;

import com.login.otroLogin.dto.reques.AuthenticationRequest;
import com.login.otroLogin.dto.response.AuthenticationResponse;

public interface IAuthenticationService {

    public AuthenticationResponse login(AuthenticationRequest request);
}
