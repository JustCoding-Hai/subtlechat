package top.javahai.subtlechat.dao;

import top.javahai.subtlechat.api.entity.GroupMsgContent;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * (GroupMsgContent)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-17 10:51:13
 */
public interface GroupMsgContentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GroupMsgContent queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<GroupMsgContent> queryAllByLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param groupMsgContent 实例对象
     * @return 对象列表
     */
    List<GroupMsgContent> queryAll(GroupMsgContent groupMsgContent);

    /**
     * 新增数据
     *
     * @param groupMsgContent 实例对象
     * @return 影响行数
     */
    int insert(GroupMsgContent groupMsgContent);

    /**
     * 修改数据
     *
     * @param groupMsgContent 实例对象
     * @return 影响行数
     */
    int update(GroupMsgContent groupMsgContent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<GroupMsgContent> getAllGroupMsgContentByPage(@Param("page") Integer page,
                                             @Param("size") Integer size,
                                             @Param("nickname") String nickname,
                                             @Param("type") Integer type,
                                             @Param("dateScope") Date[] dateScope);

    Long getTotal(@Param("nickname") String nickname,
                  @Param("type") Integer type,
                  @Param("dateScope") Date[] dateScope);

    Integer deleteGroupMsgContentByIds(@Param("ids") Integer[] ids);
}
