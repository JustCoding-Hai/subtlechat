package top.javahai.subtlechat.service;

import top.javahai.subtlechat.api.entity.UserState;
import java.util.List;

/**
 * (UserState)表服务接口
 *
 * @author makejava
 * @since 2020-06-16 11:36:02
 */
public interface UserStateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserState queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserState> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userState 实例对象
     * @return 实例对象
     */
    UserState insert(UserState userState);

    /**
     * 修改数据
     *
     * @param userState 实例对象
     * @return 实例对象
     */
    UserState update(UserState userState);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
