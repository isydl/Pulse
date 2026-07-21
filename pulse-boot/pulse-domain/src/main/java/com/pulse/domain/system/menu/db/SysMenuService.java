package com.pulse.domain.system.menu.db;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * 菜单权限表 服务类
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    /**
     * 根据用户查询系统菜单列表
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<SysMenuEntity> getMenuListByUserId(Long userId);

}
