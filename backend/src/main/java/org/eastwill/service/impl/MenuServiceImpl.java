package org.eastwill.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eastwill.common.Constants;
import org.eastwill.domain.Menu;
import org.eastwill.pojo.Tree;
import org.eastwill.repository.MenuRepository;
import org.eastwill.service.MenuService;
import org.eastwill.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public List<String> findUserPermissions(String username) {
		// TODO Auto-generated method stub
		return menuRepository.findUserPermissions(username);
	}

	@Override
	public List<Menu> findUserMenus(String username) {
		// TODO Auto-generated method stub
		return menuRepository.findUserMenus(username);
	}
	
	@Override
    public Map<String, Object> findMenus(Sort sort,Menu menu) {
        Map<String, Object> result = new HashMap<>();
        try {
        	Example<Menu> example = Example.of(menu);
            List<Menu> menus = menuRepository.findAll(example, sort);
//            for (Menu menu2 : menus) {
//            	System.out.println("menuType:" + menu2.getType());
//			}
            List<Tree<Menu>> trees = new ArrayList<>();
            
            List<String> ids = new ArrayList<>();
            buildTrees(trees, menus, ids);

            result.put("ids", ids);
            if (StringUtils.equals(menu.getType(), Constants.TYPE_BUTTON)) {
                result.put("rows", trees);
            } else {
                Tree<Menu> menuTree = TreeUtil.build(trees);
                result.put("rows", menuTree);
            }

            result.put("total", menus.size());
        } catch (NumberFormatException e) {
            log.error("查询菜单失败", e);
            result.put("rows", null);
            result.put("total", 0);
        }
        return result;
    }
	
	private void buildTrees(List<Tree<Menu>> trees, List<Menu> menus, List<String> ids) {
        menus.forEach(menu -> {
            ids.add(menu.getMenuId().toString());
            Tree<Menu> tree = new Tree<>();
            tree.setId(menu.getMenuId().toString());
            tree.setKey(tree.getId());
            tree.setParentId(menu.getParentId().toString());
            tree.setText(menu.getMenuName());
            tree.setTitle(tree.getText());
            tree.setIcon(menu.getIcon());
            tree.setComponent(menu.getComponent());
            tree.setCreateTime(menu.getCreateTime());
            tree.setModifyTime(menu.getModifyTime());
            tree.setPath(menu.getPath());
            tree.setOrder(menu.getOrderNum());
            tree.setPermission(menu.getPerms());
            tree.setType(menu.getType());
            trees.add(tree);
        });
    }

	@Override
	public List<String> findUserActions(String username) {
		// TODO Auto-generated method stub
		return menuRepository.findUserActions(username);
	}


}
