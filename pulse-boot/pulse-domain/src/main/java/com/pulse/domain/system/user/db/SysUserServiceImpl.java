package com.pulse.domain.system.user.db;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户信息表 服务实现类
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Override
    public boolean isUserNameDuplicated(String username) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return this.baseMapper.exists(queryWrapper);
    }

    @Override
    public SysUserEntity getUserByUserName(String userName) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userName);
        return this.getOne(queryWrapper);
    }

}
