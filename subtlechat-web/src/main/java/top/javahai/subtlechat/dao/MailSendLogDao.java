package top.javahai.subtlechat.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import top.javahai.subtlechat.api.entity.MailSendLog;

import java.util.Date;
import java.util.List;

/**
 * (MailSendLog)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-02 14:40:33
 */
public interface MailSendLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param msgId 主键
     * @return 实例对象
     */
    MailSendLog queryById(String msgId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MailSendLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mailSendLog 实例对象
     * @return 对象列表
     */
    List<MailSendLog> queryAll(MailSendLog mailSendLog);

    /**
     * 新增数据
     *
     * @param mailSendLog 实例对象
     * @return 影响行数
     */
    int insert(MailSendLog mailSendLog);

    /**
     * 修改数据
     *
     * @param mailSendLog 实例对象
     * @return 影响行数
     */
    int update(MailSendLog mailSendLog);

    /**
     * 通过主键删除数据
     *
     * @param msgId 主键
     * @return 影响行数
     */
    int deleteById(String msgId);

    void updateMailSendLogStatus(@Param("msgId") String msgId,@Param("status") int i);

    List<MailSendLog> getMailSendLogsByStatus(@Param("delivering") Integer delivering);

    void updateCount(@Param("msgId") String msgId,@Param("date") Date date);

    String getMsgById(@Param("msgId") String msgId);
}
