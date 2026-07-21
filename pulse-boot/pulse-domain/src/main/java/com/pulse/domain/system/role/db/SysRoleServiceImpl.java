package com.pulse.domain.system.role.db;

import com.pulse.domain.system.menu.db.SysMenuEntity;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 角色信息表 服务实现类
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {

    @Override
    public List<SysMenuEntity> getMenuListByRoleId(Long roleId) {
        return baseMapper.getMenuListByRoleId(roleId);
    }

}
