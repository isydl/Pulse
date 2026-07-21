package com.pulse.domain.system.user.db;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户信息表 服务类
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 检测用户名是否唯一
     * @param userName 用户名
     * @return 校验结果
     */
    boolean isUserNameDuplicated(String userName);

    /**
     * 通过用户名查询用户
     * @param userName 用户名
     * @return 用户对象信息
     */
    SysUserEntity getUserByUserName(String userName);

}
