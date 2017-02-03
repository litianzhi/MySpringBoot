package com.forsrc.boot.web.security;


import com.forsrc.boot.web.user.service.UserService;
import com.forsrc.pojo.UserPrivacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPrivacy user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User is not exist: %s", username));
        }
        MyUserDetails myUserDetails = new MyUserDetails(user.getUsername(), user.getPassword());

        return myUserDetails;
    }
}
