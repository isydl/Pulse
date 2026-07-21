--- Pulse Admin H2 Schema
--- Only contains tables needed for login/logout/homepage: sys_user, sys_menu, sys_role, sys_role_menu

--- int后面不能带数字， 索引相关的语句也不允许， 保留最简单原始的语句即可

create sequence if not exists sys_menu_seq start with 2 increment by 1;
create table sys_menu
(
    menu_id     bigint auto_increment comment '菜单ID'
        primary key,
    menu_name   varchar(64)                not null comment '菜单名称',
    menu_type   smallint      default 0    not null comment '菜单的类型(1为普通菜单2为目录3为内嵌iFrame4为外链跳转)',
    router_name varchar(255)  default ''   not null comment '路由名称',
    parent_id   bigint        default 0    not null comment '父菜单ID',
    path        varchar(255)               null comment '组件路径',
    is_button   tinyint(1)    default 0    not null comment '是否按钮',
    permission  varchar(128)               null comment '权限标识',
    meta_info   varchar(1024) default '{}' not null comment '路由元信息',
    status      smallint      default 0    not null comment '菜单状态（1启用 0停用）',
    remark      varchar(256)  default ''   null comment '备注',
    creator_id  bigint                     null comment '创建者ID',
    create_time datetime                   null comment '创建时间',
    updater_id  bigint                     null comment '更新者ID',
    update_time datetime                   null comment '更新时间',
    deleted     tinyint(1)    default 0    not null comment '逻辑删除'
);

create sequence if not exists sys_role_seq start with 3 increment by 1;
create table sys_role
(
    role_id      bigint default next value for sys_role_seq,
    role_name    varchar(32)              not null comment '角色名称',
    role_key     varchar(128)             not null comment '角色权限字符串',
    role_sort    int                      not null comment '显示顺序',
    data_scope   smallint      default 1  null comment '数据范围',
    dept_id_set  varchar(1024) default '' null comment '角色所拥有的部门数据权限',
    status       smallint                 not null comment '角色状态（1正常 0停用）',
    creator_id   bigint                   null comment '创建者ID',
    create_time  datetime                 null comment '创建时间',
    updater_id   bigint                   null comment '更新者ID',
    update_time  datetime                 null comment '更新时间',
    remark       varchar(512)             null comment '备注',
    deleted      tinyint    default 0     not null comment '删除标志（0代表存在 1代表删除）'
);

create table sys_role_menu
(
    role_id bigint auto_increment not null comment '角色ID',
    menu_id bigint auto_increment not null comment '菜单ID'
);

create sequence if not exists sys_user_seq start with 3 increment by 1;
create table sys_user
(
    user_id      bigint default next value for sys_user_seq,
    post_id      bigint                  null comment '职位id',
    role_id      bigint                  null comment '角色id',
    dept_id      bigint                  null comment '部门ID',
    username     varchar(64)             not null comment '用户账号',
    nickname    varchar(32)             not null comment '用户昵称',
    user_type    smallint     default 0  null comment '用户类型（00系统用户）',
    email        varchar(128) default '' null comment '用户邮箱',
    phone_number varchar(18)  default '' null comment '手机号码',
    sex          smallint     default 0  null comment '用户性别（0男 1女 2未知）',
    avatar       varchar(512) default '' null comment '头像地址',
    password     varchar(128) default '' not null comment '密码',
    status       smallint     default 0  not null comment '帐号状态（1正常 2停用 3冻结）',
    login_ip     varchar(128) default '' null comment '最后登录IP',
    login_date   datetime                null comment '最后登录时间',
    is_admin     tinyint   default 0     not null comment '超级管理员标志（1是，0否）',
    creator_id   bigint                  null comment '更新者ID',
    create_time  datetime                null comment '创建时间',
    updater_id   bigint                  null comment '更新者ID',
    update_time  datetime                null comment '更新时间',
    remark       varchar(512)            null comment '备注',
    deleted      tinyint   default 0     not null comment '删除标志（0代表存在 1代表删除）'
);

CREATE ALIAS FIND_IN_SET FOR "com.pulse.infrastructure.mybatisplus.MySqlFunction.findInSet";
