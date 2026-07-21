package com.pulse.domain.system.user;

import com.pulse.domain.common.cache.CacheCenter;
import com.pulse.domain.common.dto.CurrentLoginUserDTO;
import com.pulse.domain.system.user.dto.UserDTO;
import com.pulse.infrastructure.user.web.SystemLoginUser;
import com.pulse.domain.system.user.db.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author valarchie
 */
@Service
@RequiredArgsConstructor
public class UserApplicationService {

    private final SysUserService userService;


    /**
     * 获取当前登录用户信息
     *
     * @return 当前登录用户信息
     */
    public CurrentLoginUserDTO getLoginUserInfo(SystemLoginUser loginUser) {
        CurrentLoginUserDTO permissionDTO = new CurrentLoginUserDTO();

        permissionDTO.setUserInfo(new UserDTO(CacheCenter.userCache.getObjectById(loginUser.getUserId())));
        permissionDTO.setRoleKey(loginUser.getRoleInfo().getRoleKey());
        permissionDTO.setPermissions(loginUser.getRoleInfo().getMenuPermissions());

        return permissionDTO;
    }

}
