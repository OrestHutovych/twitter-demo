package com.example.twitterdemo.security.service.impl;

import com.example.twitterdemo.security.service.AccessTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AccessTokenServiceImpl implements AccessTokenService {
    private final JwtEncoder jwtEncoder;
    @Override
    public String generateIdToken(Authentication authentication) {
        UserDetails userDetails = Optional
                .of(authentication.getPrincipal())
                .filter(UserDetails.class::isInstance)
                .map(UserDetails.class::cast)
                .orElseThrow(() -> new RuntimeException("Can't make UserDetails object using Authentication"));

        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        JwtClaimsSet jwtClaimsSet = JwtClaimsSet
                .builder()
                .claim("scope", roles)
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(1, ChronoUnit.DAYS))
                .subject(userDetails.getUsername())
                .build();
        return jwtEncoder.encode(JwtEncoderParameters
                .from(jwtClaimsSet))
                .getTokenValue();
    }
}
