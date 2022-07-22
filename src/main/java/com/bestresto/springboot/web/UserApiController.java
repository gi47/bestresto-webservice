//package com.bestresto.springboot.web;
//
//
//import com.bestresto.springboot.config.auth.LoginUser;
//import com.bestresto.springboot.config.auth.dto.SessionUser;
//import com.bestresto.springboot.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RestController
//public class UserApiController {
//
//    private final UserService userService;
//
//    //회원가입
//    @PostMapping("/api/v1/user")
//    public Long save(@RequestBody UserSaveRequestDto requestDto) {
//        System.out.println("컨트롤러");
//        return userService.save(requestDto);
//    }
//
//
//}
