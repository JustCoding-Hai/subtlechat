package top.javahai.subtlechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.javahai.subtlechat.api.entity.Feedback;
import top.javahai.subtlechat.api.entity.RespBean;
import top.javahai.subtlechat.service.FeedbackService;


/**
 * 邮箱服务控制器
 * @author Hai
 * @date 2020/6/29 - 18:42
 */
@RestController
@RequestMapping("/mail")
public class MailController {


  @Autowired
  FeedbackService feedbackService;
  /**
   * 发送反馈消息给系统管理员
   * @param feedback
   * @return
   */
  @PostMapping("/feedback")
  public RespBean sendFeedbackToMail(@RequestBody Feedback feedback){
      try{
        feedbackService.sendMessage(feedback);
      }catch (Exception e){
        e.printStackTrace();
      }finally {
        return RespBean.ok("邮件发送成功！感谢你的反馈~");
      }
  }
}
