package com.login.otroLogin.service.iface;

import com.login.otroLogin.models.User;

import java.util.Map;

public interface IJwtService {

    public String generateToken(User user, Map<String, Object> claims);

    public String extractUsername(String jwt);
}
