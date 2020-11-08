package top.javahai.subtlechat.service.impl;

import top.javahai.subtlechat.api.entity.UserState;
import top.javahai.subtlechat.dao.UserStateDao;
import top.javahai.subtlechat.service.UserStateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserState)表服务实现类
 *
 * @author makejava
 * @since 2020-06-16 11:36:02
 */
@Service("userStateService")
public class UserStateServiceImpl implements UserStateService {
    @Resource
    private UserStateDao userStateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserState queryById(Integer id) {
        return this.userStateDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserState> queryAllByLimit(int offset, int limit) {
        return this.userStateDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userState 实例对象
     * @return 实例对象
     */
    @Override
    public UserState insert(UserState userState) {
        this.userStateDao.insert(userState);
        return userState;
    }

    /**
     * 修改数据
     *
     * @param userState 实例对象
     * @return 实例对象
     */
    @Override
    public UserState update(UserState userState) {
        this.userStateDao.update(userState);
        return this.queryById(userState.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userStateDao.deleteById(id) > 0;
    }
}
