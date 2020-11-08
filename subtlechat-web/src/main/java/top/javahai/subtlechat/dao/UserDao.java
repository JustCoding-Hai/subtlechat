package top.javahai.subtlechat.dao;

import top.javahai.subtlechat.api.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-16 12:06:29
 */
public interface UserDao {

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    User loadUserByUsername(String username);


    /**
     * 获取除当前用户的所有用户
     * @param id
     * @return
     */
    List<User> getUsersWithoutCurrentUser(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    void setUserStateToOn(Integer id);

    void setUserStateToLeave(Integer id);

    Integer checkUsername(String username);

    Integer checkNickname(String nickname);

    List<User> getAllUserByPage(@Param("page") Integer page, @Param("size") Integer size,String keyword,Integer isLocked);

    Long getTotal(@Param("keyword") String keyword,@Param("isLocked") Integer isLocked);

    Integer changeLockedStatus(@Param("id") Integer id, @Param("isLocked") Boolean isLocked);

  Integer deleteByIds(@Param("ids") Integer[] ids);
}
