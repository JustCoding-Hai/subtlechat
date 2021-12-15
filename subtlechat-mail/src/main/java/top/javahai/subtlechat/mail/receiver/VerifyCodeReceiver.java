package top.javahai.subtlechat.mail.receiver;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * 处理发送验证码的消息，保证消息不会重复消费
 * @author Hai
 * @date 2020/10/2 - 23:25
 */
@Component
public class VerifyCodeReceiver {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    StringRedisTemplate redisTemplate;

    private static final Logger LOGGER= LoggerFactory.getLogger(VerifyCodeReceiver.class);

    @RabbitListener(queues = "${mail.queue.verifyCode:mail-queue-verifyCode}")
    public void getMessage(Message message, Channel channel) throws IOException {
        //获取消息内容
        String code = message.getPayload().toString();
        //获取消息头，消息标志tag
        MessageHeaders headers = message.getHeaders();
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //获取消息ID
        String msgId = (String) headers.get("spring_returned_message_correlation");
        LOGGER.info("【"+msgId+"】-正在处理的消息");
        //查看消息是否已消费
        if (redisTemplate.opsForHash().entries("mail_log").containsKey(msgId)){
            //手动确认消息已消费
            channel.basicAck(tag,false);
            LOGGER.info("【"+msgId+"】消息出现重复消费");
            return;
        }
        //否则进行消息消费
        try{
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setSubject("微言聊天室管理端-验证码验证");
            //TODO 使用Thymeleaf，改邮件模板,添加内容：请不要泄露自己的邮箱验证码
            msg.setText("本次登录的验证码："+code);
            msg.setFrom("发送者的邮箱地址");
            msg.setSentDate(new Date());
            msg.setTo("接受者的邮箱地址");
            javaMailSender.send(msg);
            //消息发送成功，将id放到redis中,不能这样put
            //redisTemplate.opsForHash().entries("mail_log").put(msgId,code);
            redisTemplate.opsForHash().put("mail_log",msgId,code);
            //确认消息消费成功
            channel.basicAck(tag,false);
        }catch (Exception e){
            //不批量处理，将消息重新放回到队列中
            channel.basicNack(tag,false,true);
            LOGGER.info("【"+msgId+"】消息重新放回到了队列中");
            e.printStackTrace();
        }
    }
}
