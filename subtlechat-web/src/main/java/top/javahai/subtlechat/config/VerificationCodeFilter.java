package top.javahai.subtlechat.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import top.javahai.subtlechat.api.entity.RespBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截登录请求，验证输入的验证码是否正确
 * @author Hai
 * @date 2020/5/28 - 17:31
 */
@Component
public class VerificationCodeFilter extends GenericFilter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    //如果是登录请求则拦截
    if ("POST".equals(request.getMethod())&&"/doLogin".equals(request.getServletPath())){
      //TODO 不启动验证码
      filterChain.doFilter(request,response);
      //用户输入的验证码
      String code = request.getParameter("code");
      //session中保存的验证码
      String verify_code = (String) request.getSession().getAttribute("verify_code");
      response.setContentType("application/json;charset=utf-8");
      PrintWriter writer = response.getWriter();
      //验证session中保存是否存在
      try {
        //验证是否相同
        if (!code.toLowerCase().equals(verify_code.toLowerCase())){
          //输出json
          writer.write(new ObjectMapper().writeValueAsString( RespBean.error("验证码错误！")));
          return;
        }else {
          filterChain.doFilter(request,response);
        }
      }catch (NullPointerException e){
        writer.write(new ObjectMapper().writeValueAsString(RespBean.error("请求异常，请重新请求！")));
      }finally {
        writer.flush();
        writer.close();
      }
    }
    //管理端登录请求
//    else if ("POST".equals(request.getMethod())&&"/admin/doLogin".equals(request.getServletPath())){
//      //获取输入的验证码
//      String mailCode = request.getParameter("mailCode");
//      //获取session中保存的验证码
//      String verifyCode = ((String) request.getSession().getAttribute("mail_verify_code"));
//      //构建响应输出流
//      response.setContentType("application/json;charset=utf-8");
//      PrintWriter printWriter =response.getWriter();
//      try {
//        if(!mailCode.equals(verifyCode)){
//          printWriter.write(new ObjectMapper().writeValueAsString(RespBean.error("验证码错误！")));
//        }else {
//          filterChain.doFilter(request,response);
//        }
//      }catch (NullPointerException e){
//         printWriter.write(new ObjectMapper().writeValueAsString(RespBean.error("请求异常，请重新请求！")));
//      }finally {
//       printWriter.flush();
//       printWriter.close();
//      }
//    }
    else {
      filterChain.doFilter(request,response);
    }
  }
}
