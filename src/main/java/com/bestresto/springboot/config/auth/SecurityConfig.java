package com.bestresto.springboot.config.auth;


import com.bestresto.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()// h2-console 화면을 사용하기 위해 해당 옵션들을 disable
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()// URL별 권한 관리를 설정/ 선언되어야만 antMatchers 옵션을 사용
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll() // 권한 관리 대상:  URL들은 permitAll() 옵션을 통해 전체 열람 권한
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER 권한을 가진 사람만 가능
                .anyRequest().authenticated() // 설정된 값들 이외 나머지 URL, authenticated(): 나머지 URL>> 모두 인증된 사용자들(로그인 사용자)에게만 허용
                .and()
                .logout()
                .logoutSuccessUrl("/") // 로그아웃 기능에 대한 여러 설정의 진입점, 성공 시 / 주소로 이동
                .and()
                .oauth2Login()// OAuth 2 로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
                // userService:  소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
                // 소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있
    }
}