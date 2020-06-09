import java.util.List;

/**
 * @author jiang hui
 * @date 2019/8/12
 */

public interface ManagerService {

    /**
     * 管理员的登录验证
     *
     * @param username 管理员用户名
     * @param password 管理员密码
     * @return 如果验证成功则返回对应的管理员对象，失败则返回null
     */
    Manager login(String username, String password);

    /**
     * 增加管理员
     *
     * @param managerForm 前端传来的管理员信息表单
     * @return 新增的管理员对象，包括生成的id
     */
    Manager addManager(ManagerForm managerForm);

}
