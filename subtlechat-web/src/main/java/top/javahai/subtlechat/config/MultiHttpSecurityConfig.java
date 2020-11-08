package top.javahai.subtlechat.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import top.javahai.subtlechat.api.entity.Admin;
import top.javahai.subtlechat.api.entity.RespBean;
import top.javahai.subtlechat.api.entity.User;
import top.javahai.subtlechat.service.impl.AdminServiceImpl;
import top.javahai.subtlechat.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Hai
 * @date 2020/6/19 - 12:37
 */
@EnableWebSecurity
public class MultiHttpSecurityConfig {
  //密码加密方案
  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  @Configuration
  @Order(1)
  public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    AdminServiceImpl adminService;
    @Autowired
    VerificationCodeFilter verificationCodeFilter;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    MyLogoutSuccessHandler myLogoutSuccessHandler;

    //用户名和密码验证服务
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(adminService);
    }

    //忽略"/login","/verifyCode"请求，该请求不需要进入Security的拦截器
    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/css/**","/fonts/**","/img/**","/js/**","/favicon.ico","/index.html","/admin/login","/admin/mailVerifyCode");
    }
    //http请求验证和处理规则，响应处理的配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      //将验证码过滤器添加在用户名密码过滤器的前面
      http.addFilterBefore(verificationCodeFilter, UsernamePasswordAuthenticationFilter.class);
      http.antMatcher("/admin/**").authorizeRequests()
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .usernameParameter("username")
              .passwordParameter("password")
              .loginPage("/admin/login")
              .loginProcessingUrl("/admin/doLogin")
              //成功处理
              .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                  resp.setContentType("application/json;charset=utf-8");
                  PrintWriter out=resp.getWriter();
                  Admin admin=(Admin) authentication.getPrincipal();
                  admin.setPassword(null);
                  RespBean ok = RespBean.ok("登录成功", admin);
                  String s = new ObjectMapper().writeValueAsString(ok);
                  out.write(s);
                  out.flush();
                  out.close();
                }
              })
              //失败处理
              .failureHandler(myAuthenticationFailureHandler)
              .permitAll()//返回值直接返回
              .and()
              //登出处理
              .logout()
              .logoutUrl("/admin/logout")
              .logoutSuccessHandler(myLogoutSuccessHandler)
              .permitAll()
              .and()
              .csrf().disable()//关闭csrf防御方便调试
              //没有认证时，在这里处理结果，不进行重定向到login页
              .exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
        @Override
        public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
          httpServletResponse.setStatus(401);
        }
      });
    }
}
  @Configuration
  @Order(2)
  public static class UserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    VerificationCodeFilter verificationCodeFilter;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    //验证服务
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userService);
    }

//    //密码加密
//    @Bean
//    PasswordEncoder passwordEncoder(){
//      return new BCryptPasswordEncoder();
//    }


    //忽略"/login","/verifyCode"请求，该请求不需要进入Security的拦截器
    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/login","/verifyCode","/file","/user/register","/user/checkUsername","/user/checkNickname");
    }
    //登录验证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      //将验证码过滤器添加在用户名密码过滤器的前面
      http.addFilterBefore(verificationCodeFilter, UsernamePasswordAuthenticationFilter.class);
      http.authorizeRequests()
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .usernameParameter("username")
              .passwordParameter("password")
              .loginPage("/login")
              .loginProcessingUrl("/doLogin")
              //成功处理
              .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                  resp.setContentType("application/json;charset=utf-8");
                  PrintWriter out=resp.getWriter();
                  User user=(User) authentication.getPrincipal();
                  user.setPassword(null);
                  //更新用户状态为在线
                  userService.setUserStateToOn(user.getId());
                  user.setUserStateId(1);
                  //广播系统通知消息
                  simpMessagingTemplate.convertAndSend("/topic/notification","系统消息：用户【"+user.getNickname()+"】进入了聊天室");
                  RespBean ok = RespBean.ok("登录成功", user);
                  String s = new ObjectMapper().writeValueAsString(ok);
                  out.write(s);
                  out.flush();
                  out.close();
                }
              })
              //失败处理
              .failureHandler(myAuthenticationFailureHandler)
              .permitAll()//返回值直接返回
              .and()
              //登出处理
              .logout()
              .logoutUrl("/logout")
              .logoutSuccessHandler(new LogoutSuccessHandler() {
                @Override
                public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                  //更新用户状态为离线
                  User user = (User) authentication.getPrincipal();
                  userService.setUserStateToLeave(user.getId());
                  //广播系统消息
                  simpMessagingTemplate.convertAndSend("/topic/notification","系统消息：用户【"+user.getNickname()+"】退出了聊天室");
                  resp.setContentType("application/json;charset=utf-8");
                  PrintWriter out=resp.getWriter();
                  out.write(new ObjectMapper().writeValueAsString(RespBean.ok("成功退出！")));
                  out.flush();
                  out.close();
                }
              })
              .permitAll()
              .and()
              .csrf().disable()//关闭csrf防御方便调试
              //没有认证时，在这里处理结果，不进行重定向到login页
              .exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
        @Override
        public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
          httpServletResponse.setStatus(401);
        }
      });
    }
  }

}
