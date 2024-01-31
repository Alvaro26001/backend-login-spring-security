package com.login.otroLogin.service.iface;

import com.login.otroLogin.dto.reques.AuthenticationRequest;
import com.login.otroLogin.dto.response.AuthenticationResponse;

public interface IUserService {

    public AuthenticationResponse login(AuthenticationRequest request);
}
