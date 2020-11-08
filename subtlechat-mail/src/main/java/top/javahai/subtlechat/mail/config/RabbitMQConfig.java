package top.javahai.subtlechat.mail.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Hai
 * @date 2020/10/1 - 18:32
 */
@Configuration
public class RabbitMQConfig {

    @Value("${mail.exchange:mail-exchange}")
    private String mailExchange;

    @Value("${mail.queue.verifyCode:mail-queue-verifyCode}")
    private String mailQueueVerifyCode;

    @Value("${mail.route.verifyCode:mail-route-verifyCode}")
    private String mailRouteVerifyCode;

    @Value("${mail.queue.feedback:mail-queue-feedback}")
    private String mailQueueFeedback;

    @Value("${mail.route.feedback:mail-route-feedback}")
    private String mailRouteFeedback;


    @Bean
    DirectExchange mailExchange(){
        return new DirectExchange(mailExchange,true,false);
    }

    /**
     * 验证码消息队列
     * @return
     */
    @Bean
    Queue mailQueueVerifyCode(){
        return new Queue(mailQueueVerifyCode,true);
    }

    @Bean
    Binding mailQueueVerifyCodeBinding(){
        return BindingBuilder.bind(mailQueueVerifyCode()).to(mailExchange()).with(mailRouteVerifyCode);
    }

    /**
     * 反馈消息队列
     * @return
     */
    @Bean
    Queue mailQueueFeedback(){
        return new Queue(mailQueueFeedback,true);
    }
    @Bean
    Binding mailQueueFeedbackBinding(){
        return BindingBuilder.bind(mailQueueFeedback()).to(mailExchange()).with(mailRouteFeedback);
    }

}
