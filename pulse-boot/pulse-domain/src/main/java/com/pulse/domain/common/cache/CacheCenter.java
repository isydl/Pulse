package com.pulse.domain.common.cache;

import cn.hutool.extra.spring.SpringUtil;
import com.pulse.infrastructure.cache.guava.AbstractGuavaCacheTemplate;
import com.pulse.infrastructure.cache.redis.RedisCacheTemplate;
import com.pulse.infrastructure.user.web.SystemLoginUser;
import com.pulse.domain.system.role.db.SysRoleEntity;
import com.pulse.domain.system.user.db.SysUserEntity;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * 缓存中心  提供全局访问点
 */
@Component
public class CacheCenter {

    public static RedisCacheTemplate<String> captchaCache;

    public static RedisCacheTemplate<SystemLoginUser> loginUserCache;

    public static RedisCacheTemplate<SysUserEntity> userCache;

    public static RedisCacheTemplate<SysRoleEntity> roleCache;

    @PostConstruct
    public void init() {
        RedisCacheService redisCache = SpringUtil.getBean(RedisCacheService.class);

        captchaCache = redisCache.captchaCache;
        loginUserCache = redisCache.loginUserCache;
        userCache = redisCache.userCache;
        roleCache = redisCache.roleCache;
    }

}
