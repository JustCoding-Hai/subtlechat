package top.javahai.subtlechat.service;

import top.javahai.subtlechat.api.entity.MailSendLog;

import java.util.Date;
import java.util.List;

/**
 * (MailSendLog)表服务接口
 *
 * @author makejava
 * @since 2020-10-02 14:40:33
 */
public interface MailSendLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    MailSendLog queryById(String msgId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MailSendLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mailSendLog 实例对象
     * @return 实例对象
     */
    MailSendLog insert(MailSendLog mailSendLog);

    /**
     * 修改数据
     *
     * @param mailSendLog 实例对象
     * @return 实例对象
     */
    MailSendLog update(MailSendLog mailSendLog);

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 是否成功
     */
    boolean deleteById(String msgId);

    void updateMailSendLogStatus(String msgId, int i);

    List<MailSendLog> getMailSendLogsByStatus(Integer delivering);

    void updateCount(String msgId, Date date);

    String getMsgById(String msgId);
}
