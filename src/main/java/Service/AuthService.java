package Service;

import Request.AuthRequest;
import Request.AuthResponse;
import Security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    public AuthResponse authenticate(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword());
        authenticationManager.authenticate(authenticationToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return new AuthResponse(token);
    }
}
