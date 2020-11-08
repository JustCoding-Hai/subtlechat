package top.javahai.subtlechat.service.impl;

import top.javahai.subtlechat.api.entity.MailSendLog;
import top.javahai.subtlechat.dao.MailSendLogDao;
import top.javahai.subtlechat.service.MailSendLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (MailSendLog)表服务实现类
 *
 * @author makejava
 * @since 2020-10-02 14:40:33
 */
@Service("mailSendLogService")
public class MailSendLogServiceImpl implements MailSendLogService {
    @Resource
    private MailSendLogDao mailSendLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    @Override
    public MailSendLog queryById(String msgId) {
        return this.mailSendLogDao.queryById(msgId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MailSendLog> queryAllByLimit(int offset, int limit) {
        return this.mailSendLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mailSendLog 实例对象
     * @return 实例对象
     */
    @Override
    public MailSendLog insert(MailSendLog mailSendLog) {
        this.mailSendLogDao.insert(mailSendLog);
        return mailSendLog;
    }

    /**
     * 修改数据
     *
     * @param mailSendLog 实例对象
     * @return 实例对象
     */
    @Override
    public MailSendLog update(MailSendLog mailSendLog) {
        this.mailSendLogDao.update(mailSendLog);
        return this.queryById(mailSendLog.getMsgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String msgId) {
        return this.mailSendLogDao.deleteById(msgId) > 0;
    }

    @Override
    public void updateMailSendLogStatus(String msgId, int i) {
        this.mailSendLogDao.updateMailSendLogStatus(msgId,i);
    }

    @Override
    public List<MailSendLog> getMailSendLogsByStatus(Integer delivering) {
        return this.mailSendLogDao.getMailSendLogsByStatus(delivering);
    }

    @Override
    public void updateCount(String msgId, Date date) {
        this.mailSendLogDao.updateCount(msgId,date);
    }

    @Override
    public String getMsgById(String msgId) {
        return  this.mailSendLogDao.getMsgById(msgId);
    }


}
