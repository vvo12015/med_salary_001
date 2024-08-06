package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.SecurityUser;
import net.vrakin.med_salary.repository.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private SecurityUserRepository securityUserRepository;

    public CustomUserDetailsService(SecurityUserRepository securityUserRepository) {
        this.securityUserRepository = securityUserRepository;
    }

    @Autowired


    @Override
    public UserDetails loadUserByUsername(String loginOrEmail) throws UsernameNotFoundException {
        SecurityUser user = securityUserRepository.findByLoginOrEmail(loginOrEmail, loginOrEmail)
                .orElseThrow(()->new UsernameNotFoundException("User not exists by login or email"));

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getSecurityRole().toString()));


        return new User(
                user.getLogin(),
                user.getPassword(),
                authorities
        );
    }
}
