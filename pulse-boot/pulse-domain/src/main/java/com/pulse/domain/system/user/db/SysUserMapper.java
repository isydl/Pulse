package com.pulse.domain.system.user.db;

import com.pulse.domain.system.role.db.SysRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * 用户信息表 Mapper 接口
 */
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    @Select("SELECT DISTINCT r.* "
        + "FROM sys_role r "
        + " LEFT JOIN sys_user u ON u.role_id = r.role_id "
        + "WHERE r.deleted = 0 "
        + " AND u.user_id = #{userId}")
    List<SysRoleEntity> getRolesByUserId(Long userId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Select("SELECT DISTINCT m.perms "
        + "FROM sys_menu m "
        + " LEFT JOIN sys_role_menu rm ON m.menu_id = rm.menu_id "
        + " LEFT JOIN sys_user u ON rm.role_id = u.role_id "
        + " LEFT JOIN sys_role r ON r.role_id = u.role_id "
        + "WHERE m.status = 1 AND m.deleted = 0 "
        + " AND r.status = 1 AND r.deleted = 0 "
        + " AND u.user_id = #{userId}")
    Set<String> getMenuPermsByUserId(Long userId);

}
