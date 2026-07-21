package com.pulse.domain.system.menu;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.pulse.domain.system.menu.dto.RouterDTO;
import com.pulse.infrastructure.user.web.SystemLoginUser;
import com.pulse.common.enums.common.StatusEnum;
import com.pulse.domain.system.menu.db.SysMenuEntity;
import com.pulse.domain.system.menu.db.SysMenuService;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 菜单应用服务
 * @author valarchie
 */
@Service
@RequiredArgsConstructor
public class MenuApplicationService {

    private final SysMenuService menuService;


    public List<Tree<Long>> buildMenuEntityTree(SystemLoginUser loginUser) {
        List<SysMenuEntity> allMenus;
        if (loginUser.isAdmin()) {
            allMenus = menuService.list();
        } else {
            allMenus = menuService.getMenuListByUserId(loginUser.getUserId());
        }

        // 传给前端的路由排除掉按钮和停用的菜单
        List<SysMenuEntity> noButtonMenus = allMenus.stream()
            .filter(menu -> !menu.getIsButton())
            .filter(menu-> StatusEnum.ENABLE.getValue().equals(menu.getStatus()))
            .collect(Collectors.toList());

        TreeNodeConfig config = new TreeNodeConfig();
        // 默认为id 可以不设置
        config.setIdKey("menuId");

        return TreeUtil.build(noButtonMenus, 0L, config, (menu, tree) -> {
            tree.setId(menu.getMenuId());
            tree.setParentId(menu.getParentId());
            tree.putExtra("entity", menu);
        });

    }


    public List<RouterDTO> buildRouterTree(List<Tree<Long>> trees) {
        List<RouterDTO> routers = new LinkedList<>();
        if (CollUtil.isNotEmpty(trees)) {
            for (Tree<Long> tree : trees) {
                Object entity = tree.get("entity");
                if (entity != null) {
                    RouterDTO routerDTO = new RouterDTO((SysMenuEntity) entity);
                    List<Tree<Long>> children = tree.getChildren();
                    if (CollUtil.isNotEmpty(children)) {
                        routerDTO.setChildren(buildRouterTree(children));
                    }
                    routers.add(routerDTO);
                }

            }
        }
        return routers;
    }


    public List<RouterDTO> getRouterTree(SystemLoginUser loginUser) {
        List<Tree<Long>> trees = buildMenuEntityTree(loginUser);
        return buildRouterTree(trees);
    }

}
