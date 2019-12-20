package com.macro.mall.portal.config;

import com.macro.mall.model.UmsMember;
import com.macro.mall.portal.component.*;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import com.macro.mall.component.RestfulAccessDeniedHandler;
/**
 * SpringSecurity的配置
 * Created by macro on 2018/8/3.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsMemberService memberService;

    // @Autowired
    // private restfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
                .antMatchers(
                        "/sso/*",//登录注册
                        "/home/**",//首页接口
                        "/product/**",//商品详情
                        "/cnarea/**" //地址查询
                )
                .permitAll()
                /*.antMatchers("/**")//测试时全部运行访问
                .permitAll()*/
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new GoAccessDeniedHandler())
                .authenticationEntryPoint(new GoAuthenticationEntryPoint())
                .and()
                .formLogin()
                .loginPage("/sso/login")
                .successHandler(new GoAuthenticationSuccessHandler())
                .failureHandler(new GoAuthenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/sso/logout")
                .logoutSuccessHandler(new GoLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .and()
                .csrf()
                .disable();//开启basic认证登录后可以调用需要认证的接口
        // 禁用缓存
        http.headers().cacheControl();
        // 添加JWT filter
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        // http.exceptionHandling()
        //         .accessDeniedHandler(restfulAccessDeniedHandler)
        //         .authenticationEntryPoint(restAuthenticationEntryPoint);
    
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UmsMember member = memberService.getByUsername(username);
                if(member!=null){
                    return new MemberDetails(member);
                }
                throw new UsernameNotFoundException("用户名或密码错误");
            }
        };
    }
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
