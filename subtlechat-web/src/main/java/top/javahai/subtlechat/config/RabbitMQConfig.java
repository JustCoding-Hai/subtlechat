package top.javahai.subtlechat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.javahai.subtlechat.api.entity.MailConstants;
import top.javahai.subtlechat.service.MailSendLogService;

/**
 * 自定义消息发送RabbitTemplate
 * @author Hai
 * @date 2020/10/2 - 14:35
 */
@Configuration
public class RabbitMQConfig {
    public static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQConfig.class);

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;
    @Autowired
    MailSendLogService mailSendLogService;

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        //成功投递消息到Broker交换机站点的回调函数
        rabbitTemplate.setConfirmCallback((data,ack,cause)->{
            String msgId = data.getId();
            if(ack){
                LOGGER.info(msgId+"消息发送成功");
                //修改数据库中的记录，消息发送成功，将status设为1
                mailSendLogService.updateMailSendLogStatus(msgId, MailConstants.SUCCESS);
            }else{
                LOGGER.error(msgId+"消息发送失败！");
            }
        });
        //消息投递到Queue队列失败的回调函数
        rabbitTemplate.setReturnCallback((msg,repCode,repText,exchange,routingKey)->{
            LOGGER.error(msg.getBody()+"----消息从交换机投递到队列失败！\n错误原因："+repText);
            LOGGER.error("发送错误的交换机："+exchange+",发生错误的路由key："+routingKey);
        });
        return rabbitTemplate;
    }
}
