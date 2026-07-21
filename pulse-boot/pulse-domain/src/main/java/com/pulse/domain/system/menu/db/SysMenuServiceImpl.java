package com.pulse.domain.system.menu.db;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 菜单权限表 服务实现类
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {

    @Override
    public List<SysMenuEntity> getMenuListByUserId(Long userId) {
        return baseMapper.selectMenuListByUserId(userId);
    }

}
