package com.example.spring.bootjwt.service;

import com.example.spring.bootjwt.model.MyUserDetails;
import com.example.spring.bootjwt.model.User;
import com.example.spring.bootjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<User> user= userRepository.findByUserName(userName);
       user.orElseThrow(()->new UsernameNotFoundException("user not found for "+userName));
        return user.map(MyUserDetails::new).get();
    }
}
