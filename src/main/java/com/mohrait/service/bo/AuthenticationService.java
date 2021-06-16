package com.mohrait.service.bo;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mohrait.common.Utils;
import com.mohrait.common.staticdata.TokenType;
import com.mohrait.dto.AuthenticationResponseInfo;
import com.mohrait.dto.GrandAuthorityRoleInfo;
import com.mohrait.entity.JwtToken;
import com.mohrait.mapper.JwtResponseMapper;
import com.mohrait.repository.JwtTokenRepository;
import com.mohrait.repository.UserRepository;
import com.mohrait.security.JwtUtils;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Suresh Stalin on 06 / Nov / 2020.
 */

@Service
public class AuthenticationService implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private JwtTokenRepository jwtTokenRepository;

        @Autowired
        private JwtUtils jwtUtils;

        @Autowired
        private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        com.mohrait.entity.User user = userRepository.findByEmailId(emailId);
        GrandAuthorityRoleInfo grandAuthorityRoleSuperAdmin = new GrandAuthorityRoleInfo("SUPER_ADMIN");
        GrandAuthorityRoleInfo grandAuthorityRoleEmployee = new GrandAuthorityRoleInfo("ROLE_EMPLOYEE");
        List<GrandAuthorityRoleInfo> authorities = new ArrayList<>();
        authorities.add(grandAuthorityRoleSuperAdmin);
        authorities.add(grandAuthorityRoleEmployee);
        UserDetails userDetails = new User(user.getEmailId(), user.getPassword(), authorities);
        return userDetails;
    }

    public JwtToken saveJwt(AuthenticationResponseInfo authenticationResponseDto) {

        JwtToken jwtToken = JwtResponseMapper.INSTANCE.authResponseToJwt(authenticationResponseDto);
        JwtToken jwtTokenResponse = jwtTokenRepository.save(jwtToken);
        return jwtTokenResponse;
    }

    public AuthenticationResponseInfo generateAuthResponse(UserDetails userDetails, TokenType tokenType) {

        JwtToken jwtToken = jwtTokenRepository.findByUserName(userDetails.getUsername());
        AuthenticationResponseInfo authenticationResponseDTO = null;
        if(tokenType.equals(TokenType.ACCESS_TOKEN)) {
            String accessToken = jwtUtils.generateAccessToken(userDetails);
            final Claims accessclaims = jwtUtils.extractAllClaims(accessToken);
            String refreshToken = jwtUtils.generateRefreshToken(userDetails);
            final Claims refreshClaims = jwtUtils.extractAllClaims(refreshToken);
            authenticationResponseDTO = new AuthenticationResponseInfo();
            authenticationResponseDTO.setAccessToken(accessToken);
            authenticationResponseDTO.setRefreshToken(refreshToken);
            authenticationResponseDTO.setUserName(userDetails.getUsername());
            authenticationResponseDTO.setAccessTokenExpiration(Utils.convertToLocalDateTime(accessclaims.getExpiration().getTime()));
            authenticationResponseDTO.setRefreshTokenExpiration(Utils.convertToLocalDateTime(refreshClaims.getExpiration().getTime()));
            if (jwtToken != null) {
                authenticationResponseDTO.setId(jwtToken.getId());
            }
        }
        if(tokenType.equals(TokenType.REFRESH_TOKEN)) {
            String accessToken = jwtUtils.generateAccessToken(userDetails);
            final Claims accessclaims = jwtUtils.extractAllClaims(accessToken);
            authenticationResponseDTO = new AuthenticationResponseInfo();
            authenticationResponseDTO.setAccessToken(accessToken);
            authenticationResponseDTO.setRefreshToken(jwtToken.getRefreshToken());
            authenticationResponseDTO.setUserName(userDetails.getUsername());
            authenticationResponseDTO.setAccessTokenExpiration(Utils.convertToLocalDateTime(accessclaims.getExpiration().getTime()));
            authenticationResponseDTO.setRefreshTokenExpiration(jwtToken.getRefreshTokenExpiration());
            authenticationResponseDTO.setId(jwtToken.getId());
        }

        return authenticationResponseDTO;
    }
}
