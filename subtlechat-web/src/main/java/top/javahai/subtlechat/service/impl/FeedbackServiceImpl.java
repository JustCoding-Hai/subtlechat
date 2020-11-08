package top.javahai.subtlechat.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import top.javahai.subtlechat.api.entity.Feedback;
import top.javahai.subtlechat.api.entity.MailConstants;
import top.javahai.subtlechat.api.entity.MailSendLog;
import top.javahai.subtlechat.api.utils.JsonUtil;
import top.javahai.subtlechat.dao.FeedbackDao;
import top.javahai.subtlechat.service.FeedbackService;
import org.springframework.stereotype.Service;
import top.javahai.subtlechat.service.MailSendLogService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (Feedback)表服务实现类
 *
 * @author makejava
 * @since 2020-10-02 12:19:44
 */
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackDao feedbackDao;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${mail.exchange:mail-exchange}")
    private String mailExchange;

    @Value("${mail.queue.feedback:mail-queue-feedback}")
    private String mailQueueFeedback;

    @Value("${mail.route.feedback:mail-route-feedback}")
    private String mailRouteFeedback;

    @Autowired
    private MailSendLogService mailSendLogService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Feedback queryById(String id) {
        return this.feedbackDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Feedback> queryAllByLimit(int offset, int limit) {
        return this.feedbackDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    public Feedback insert(Feedback feedback) {
        this.feedbackDao.insert(feedback);
        return feedback;
    }

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    public Feedback update(Feedback feedback) {
        this.feedbackDao.update(feedback);
        return this.queryById(feedback.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.feedbackDao.deleteById(id) > 0;
    }

    @Override
    public void sendMessage(Feedback feedback) {
        feedback.setId(UUID.randomUUID().toString());
        //插入一条记录
        insert(feedback);
        //将内容转化为JSON字符串
        String record = JsonUtil.parseToString(feedback);
        //添加消息发送记录
        String msgId=UUID.randomUUID().toString();
        MailSendLog sendLog = new MailSendLog();
        sendLog.setMsgId(msgId);
        sendLog.setContent(record);
        sendLog.setContentType(MailConstants.FEEDBACK_TYPE);
        sendLog.setCount(1);
        sendLog.setCreateTime(new Date());
        sendLog.setUpdateTime(new Date());
        //当前超过一分钟后开始重试
        sendLog.setTryTime(new Date(System.currentTimeMillis()+1000*60*MailConstants.MEG_TIMEOUT));
        sendLog.setExchange(mailExchange);
        sendLog.setRouteKey(mailRouteFeedback);
        sendLog.setStatus(MailConstants.DELIVERING);
        //新增消息发送记录
        mailSendLogService.insert(sendLog);
        //投递消息
        rabbitTemplate.convertAndSend(mailExchange,mailRouteFeedback,record,new CorrelationData(msgId));
    }
}
