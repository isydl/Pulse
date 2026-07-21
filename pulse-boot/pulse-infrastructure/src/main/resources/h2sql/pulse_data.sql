--- Pulse Admin H2 Initial Data
--- Only contains data for sys_user, sys_menu, sys_role, sys_role_menu

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO sys_menu VALUES (1, '首页', 2, '', 0, '/global', 0, '', '{"title":"首页","showParent":1,"rank":0}', 1, '', 0, '2022-05-21 08:30:54', 1, '2023-07-24 22:36:03', 0);

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'admin', '1', '1', '', '1', null, '2022-05-21 08:30:54', null, null, '超级管理员', '0');
INSERT INTO `sys_role` VALUES ('2', '普通角色', 'common', '3', '2', '', '1', null, '2022-05-21 08:30:54', null, null, '普通角色', '0');

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2', '1');

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', '1', '4', 'admin', 'admin', '0', 'pulse@example.com', '15888888889', '0', '', '$2a$10$rb1wRoEIkLbIknREEN1LH.FGs4g0oOS5t6l5LQ793nRaFO.SPHDHy', '1', '127.0.0.1', '2022-10-06 17:00:06', 1, null, '2022-05-21 08:30:54', '1', '2022-10-06 17:00:06', '管理员', '0');
INSERT INTO `sys_user` VALUES ('2', '2', '2', '5', 'user', 'user', '0', 'user@example.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '1', '127.0.0.1', '2022-05-21 08:30:54', 0, null, '2022-05-21 08:30:54', null, null, '普通用户', '0');
