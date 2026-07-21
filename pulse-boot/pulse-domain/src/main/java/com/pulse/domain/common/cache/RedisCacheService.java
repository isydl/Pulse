package com.pulse.domain.common.cache;

import cn.hutool.extra.spring.SpringUtil;
import com.pulse.infrastructure.cache.RedisUtil;
import com.pulse.infrastructure.cache.redis.CacheKeyEnum;
import com.pulse.infrastructure.cache.redis.RedisCacheTemplate;
import com.pulse.infrastructure.user.web.SystemLoginUser;
import com.pulse.domain.system.role.db.SysRoleEntity;
import com.pulse.domain.system.user.db.SysUserEntity;
import com.pulse.domain.system.role.db.SysRoleService;
import com.pulse.domain.system.user.db.SysUserService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Redis 缓存服务
 */
@Component
@RequiredArgsConstructor
public class RedisCacheService {

    private final RedisUtil redisUtil;

    public RedisCacheTemplate<String> captchaCache;
    public RedisCacheTemplate<SystemLoginUser> loginUserCache;
    public RedisCacheTemplate<SysUserEntity> userCache;
    public RedisCacheTemplate<SysRoleEntity> roleCache;

    @PostConstruct
    public void init() {

        captchaCache = new RedisCacheTemplate<>(redisUtil, CacheKeyEnum.CAPTCHAT);

        loginUserCache = new RedisCacheTemplate<>(redisUtil, CacheKeyEnum.LOGIN_USER_KEY);

        userCache = new RedisCacheTemplate<SysUserEntity>(redisUtil, CacheKeyEnum.USER_ENTITY_KEY) {
            @Override
            public SysUserEntity getObjectFromDb(Object id) {
                SysUserService userService = SpringUtil.getBean(SysUserService.class);
                return userService.getById((Serializable) id);
            }
        };

        roleCache = new RedisCacheTemplate<SysRoleEntity>(redisUtil, CacheKeyEnum.ROLE_ENTITY_KEY) {
            @Override
            public SysRoleEntity getObjectFromDb(Object id) {
                SysRoleService roleService = SpringUtil.getBean(SysRoleService.class);
                return roleService.getById((Serializable) id);
            }
        };

    }

}
