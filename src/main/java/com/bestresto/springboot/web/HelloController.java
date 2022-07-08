package com.bestresto.springboot.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController	// {1}
public class HelloController {

    @GetMapping("/hello")	// {2}
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDTO helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        //@RequestParam: 외부에서 API로 넘김 파라미터 가져오기
        return new HelloResponseDTO(name, amount);
    }
}