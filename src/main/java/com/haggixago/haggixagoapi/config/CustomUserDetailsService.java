package com.haggixago.haggixagoapi.config;

import com.haggixago.haggixagoapi.model.UserAuth;
import com.haggixago.haggixagoapi.repository.UserAuthRepository;
import com.haggixago.haggixagoapi.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserAuthRepository userAuthRepository;
    @Autowired
    PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
        final UserAuth userAuth = userAuthRepository.findUserAuthByEmail(username);
        if (username.equals("arthur@gmail.com")) {
            roles = Arrays.asList(new SimpleGrantedAuthority("Role_Admin"));
            return new User(userAuth.getEmail(), encoder.encode(userAuth.getPassword()), roles);
        }
        throw new UsernameNotFoundException(username);

    }
}
