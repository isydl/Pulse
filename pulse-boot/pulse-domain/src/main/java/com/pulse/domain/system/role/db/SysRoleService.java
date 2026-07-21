package com.pulse.domain.system.role.db;

import com.pulse.domain.system.menu.db.SysMenuEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * 角色信息表 服务类
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    /**
     * 获取用户的权限列表
     * @param roleId 角色id
     * @return 菜单列表
     */
    List<SysMenuEntity> getMenuListByRoleId(Long roleId);

}
