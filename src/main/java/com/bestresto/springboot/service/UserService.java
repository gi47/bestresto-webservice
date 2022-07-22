//package com.bestresto.springboot.service;
//
//import com.bestresto.springboot.domain.user.User;
//import com.bestresto.springboot.domain.user.UserRepository;
//
//import com.bestresto.springboot.web.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//
//public class UserService implements UserDetailsService{
//
//    private final UserRepository userRepository;
//
//    @Transactional
//    public Long save(UserSaveRequestDto requestDto) {
//        return userRepository.save(requestDto.toEntity()).getId();
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//}
