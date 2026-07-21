-- Pulse Admin PostgreSQL Schema
-- Only contains tables needed for login/logout/homepage: sys_user, sys_menu, sys_role, sys_role_menu

CREATE SCHEMA IF NOT EXISTS app;

-- 创建表 sys_menu 菜单权限表
CREATE TABLE app.sys_menu (
    menu_id     bigserial PRIMARY KEY NOT NULL,
    menu_name   VARCHAR(64) NOT NULL DEFAULT '',
    menu_type   smallint NOT NULL DEFAULT 0,
    router_name VARCHAR(255) NOT NULL DEFAULT '',
    parent_id   int8 NOT NULL DEFAULT 0,
    path        VARCHAR(255),
    is_button   bool NOT NULL DEFAULT false,
    permission  VARCHAR(128),
    meta_info   VARCHAR(1024) NOT NULL DEFAULT '{}',
    status      smallint NOT NULL DEFAULT 0,
    remark      VARCHAR(256),
    creator_id  int8,
    create_time timestamp,
    updater_id  int8,
    update_time timestamp,
    deleted     smallint NOT NULL DEFAULT 0
);

COMMENT ON COLUMN app.sys_menu.menu_id IS '菜单ID';
COMMENT ON COLUMN app.sys_menu.menu_name IS '菜单名称';
COMMENT ON COLUMN app.sys_menu.menu_type IS '菜单类型';
COMMENT ON COLUMN app.sys_menu.parent_id IS '父菜单ID';
COMMENT ON COLUMN app.sys_menu.is_button IS '是否按钮';
COMMENT ON COLUMN app.sys_menu.permission IS '权限标识';
COMMENT ON COLUMN app.sys_menu.meta_info IS '路由元信息';
COMMENT ON COLUMN app.sys_menu.status IS '菜单状态';
COMMENT ON COLUMN app.sys_menu.deleted IS '逻辑删除';

-- 创建表 sys_role 角色信息表
CREATE TABLE app.sys_role (
    role_id     bigserial PRIMARY KEY NOT NULL,
    role_name   VARCHAR(32) NOT NULL,
    role_key    VARCHAR(128) NOT NULL,
    role_sort   int4 NOT NULL,
    data_scope  smallint DEFAULT 1,
    dept_id_set VARCHAR(1024) DEFAULT '',
    status      smallint NOT NULL,
    creator_id  int8,
    create_time timestamp,
    updater_id  int8,
    update_time timestamp,
    remark      VARCHAR(512),
    deleted     smallint NOT NULL DEFAULT 0
);

COMMENT ON COLUMN app.sys_role.role_id IS '角色ID';
COMMENT ON COLUMN app.sys_role.role_name IS '角色名称';
COMMENT ON COLUMN app.sys_role.role_key IS '角色权限字符串';
COMMENT ON COLUMN app.sys_role.role_sort IS '显示顺序';
COMMENT ON COLUMN app.sys_role.status IS '角色状态';

-- 创建表 sys_role_menu 角色和菜单关联表
CREATE TABLE app.sys_role_menu (
    role_id int8 NOT NULL,
    menu_id int8 NOT NULL
);

-- 创建表 sys_user 用户信息表
CREATE TABLE app.sys_user (
    user_id      bigserial PRIMARY KEY NOT NULL,
    post_id      int8,
    role_id      int8,
    dept_id      int8,
    username     VARCHAR(64) NOT NULL,
    nickname     VARCHAR(32) NOT NULL,
    user_type    smallint DEFAULT 0,
    email        VARCHAR(128) DEFAULT '',
    phone_number VARCHAR(18) DEFAULT '',
    sex          smallint DEFAULT 0,
    avatar       VARCHAR(512) DEFAULT '',
    password     VARCHAR(128) NOT NULL DEFAULT '',
    status       smallint NOT NULL DEFAULT 0,
    login_ip     VARCHAR(128) DEFAULT '',
    login_date   timestamp,
    is_admin     smallint NOT NULL DEFAULT 0,
    creator_id   int8,
    create_time  timestamp,
    updater_id   int8,
    update_time  timestamp,
    remark       VARCHAR(512),
    deleted      smallint NOT NULL DEFAULT 0
);

COMMENT ON COLUMN app.sys_user.user_id IS '用户ID';
COMMENT ON COLUMN app.sys_user.username IS '用户账号';
COMMENT ON COLUMN app.sys_user.nickname IS '用户昵称';
COMMENT ON COLUMN app.sys_user.password IS '密码';
COMMENT ON COLUMN app.sys_user.status IS '帐号状态';
COMMENT ON COLUMN app.sys_user.is_admin IS '超级管理员标志';
