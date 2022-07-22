//package com.bestresto.springboot.web;
//
//
//import com.bestresto.springboot.domain.user.Role;
//import com.bestresto.springboot.domain.user.User;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@NoArgsConstructor
//public class UserSaveRequestDto {
//
//    private String name;
//    private String email;
//    private String pwd;
//    private Long phone;
//    private String address;
//    private Role role;
//
//    @Builder
//    public UserSaveRequestDto(String name, String email, String pwd, Long phone, String address, Role role) {
//        this.name = name;
//        this.email = email;
//        this.pwd = pwd;
//        this.phone = phone;
//        this.address = address;
//        this.role = role;
//    }
//
//    public User toEntity() {
//        return User.builder()
//                .name(name)
//                .email(email)
//                .pwd(pwd)
//                .phone(phone)
//                .address(address)
//                .role(role)
//                .build();
//    }
//
//}
