package com.login.otroLogin.service.impl;

import com.login.otroLogin.dto.reques.AuthenticationRequest;
import com.login.otroLogin.dto.response.AuthenticationResponse;
import com.login.otroLogin.models.User;
import com.login.otroLogin.repository.IUserRepository;
import com.login.otroLogin.service.iface.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationImpl implements IAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private JwtImpl JwtImpl;

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()
        );

        this.authenticationManager.authenticate(authToken);

        User user = this.userRepository.findByUsername(request.getUsername()).get();

        String jwt = this.JwtImpl.generateToken(user, extractGenerateClaims(user));

        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> extractGenerateClaims(User user) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("username",user.getUsername());
        claims.put("role",user.getRole().name());
        claims.put("permission", user.getAuthorities());

        return claims;
    }
}
