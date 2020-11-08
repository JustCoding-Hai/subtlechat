package top.javahai.subtlechat.service.impl;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.javahai.subtlechat.api.entity.MailConstants;
import top.javahai.subtlechat.api.entity.MailSendLog;
import top.javahai.subtlechat.api.utils.JsonUtil;
import top.javahai.subtlechat.service.MailSendLogService;
import top.javahai.subtlechat.service.VerifyCodeService;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author Hai
 * @date 2020/10/2 - 23:27
 */
@Service("verifyCodeService")
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    MailSendLogService mailSendLogService;

    @Value("${mail.exchange:mail-exchange}")
    private String mailExchange;

    @Value("${mail.route.verifyCode:mail-route-verifyCode}")
    private String mailRouteVerifyCode;

    @Override
    public String getVerifyCode() {
        StringBuilder code=new StringBuilder();
        for (int i = 0; i <4; i++) {
            code.append(new Random().nextInt(10));
        }
        return code.toString();
    }

    @Override
    public void sendVerifyCodeMail(String code) {
        //添加消息记录
        String msgId = UUID.randomUUID().toString();
        MailSendLog mailSendLog = new MailSendLog();
        mailSendLog.setMsgId(msgId);
        mailSendLog.setContent(code);
        mailSendLog.setContentType(MailConstants.VERIFY_CODE_TYPE);
        mailSendLog.setCount(1);
        mailSendLog.setCreateTime(new Date());
        mailSendLog.setTryTime(new Date(System.currentTimeMillis()+1000*10*MailConstants.MEG_TIMEOUT));
        mailSendLog.setUpdateTime(new Date());
        mailSendLog.setExchange(mailExchange);
        mailSendLog.setRouteKey(mailRouteVerifyCode);
        mailSendLog.setStatus(MailConstants.DELIVERING);
        mailSendLogService.insert(mailSendLog);

        rabbitTemplate.convertAndSend(mailExchange,mailRouteVerifyCode,code,new CorrelationData(msgId));

    }
}
