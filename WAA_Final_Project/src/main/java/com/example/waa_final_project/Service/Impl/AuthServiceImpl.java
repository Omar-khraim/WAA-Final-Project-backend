package com.example.waa_final_project.Service.Impl;


import com.example.waa_final_project.Dto.LogIn.LogInResponseDTO;
import com.example.waa_final_project.Dto.LogIn.LoginRequestDTO;
import com.example.waa_final_project.Dto.LogIn.RefreshTokenRequestDTO;
import com.example.waa_final_project.Entity.Users;
import com.example.waa_final_project.Service.AuthService;
import com.example.waa_final_project.Service.UsersService;
import com.example.waa_final_project.Util.Helper.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    private final UsersService usersService;


    @Override
    public LogInResponseDTO login(LoginRequestDTO loginRequest) {

        // data type from security dependency
        Authentication result = null;

        try {
            // Authentication manager is an interface that comes with spring security authentication package
            result = authenticationManager.authenticate(
                    // also comes with spring security
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());
        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        Users users = usersService.findAllByEmail(loginRequest.getEmail());
        return new LogInResponseDTO(accessToken, refreshToken, users.getUsername(), users.getId(),users.getRole().getId());
    }

    @Override
    public LogInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            // TODO (check the expiration of the accessToken when request sent, if the is recent according to
            //  issue Date, then accept the renewal)
            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if (isAccessTokenExpired)
                System.out.println("ACCESS TOKEN IS EXPIRED"); // TODO Renew is this case
            else
                System.out.println("ACCESS TOKEN IS NOT EXPIRED");
            final String accessToken = jwtUtil.doGenerateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            String userName = jwtUtil.getUsernameFromToken(refreshTokenRequest.getAccessToken());
            Users users = usersService.findAllByEmail(userName);
            var loginResponse = new LogInResponseDTO(accessToken, refreshTokenRequest.getRefreshToken(), userName, users.getId(),users.getRole().getId());
            // TODO (OPTIONAL) When to renew the refresh token?
            return loginResponse;
        }
        return new LogInResponseDTO();
    }
}
