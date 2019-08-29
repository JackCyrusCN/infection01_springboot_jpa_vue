package org.eastwill.web.controller.system;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.eastwill.domain.Menu;
import org.eastwill.domain.router.VueRouter;
import org.eastwill.manager.UserManager;
import org.eastwill.pojo.QueryRequest;
import org.eastwill.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("/menu")
public class MenuController{

    private String message;

    @Autowired
    private UserManager userManager;
    @Autowired
    private MenuService menuService;

    @GetMapping("/{username}")
    public ArrayList<VueRouter<Menu>> getUserRouters(@NotBlank(message = "{required}") @PathVariable String username) {
    	return this.userManager.getUserRouters(username);
    }
    
    @GetMapping
    //@RequiresPermissions("menu:view")
    public Map<String, Object> menuList(QueryRequest queryRequest,Menu menu) {
    	//System.out.println("order=>" + queryRequest.getSortOrder() + ", field=>" + queryRequest.getSortField());
    	Direction pageOrder = Sort.Direction.ASC;
    	String pageField = "menuId";
		if (queryRequest.getSortOrder() != null && !queryRequest.getSortOrder().equals("undefined")) {
			if (queryRequest.getSortOrder().equals("ascend")) {
				pageOrder = Sort.Direction.ASC;
			}else {
				pageOrder = Sort.Direction.DESC;
			}
		}
		if  (queryRequest.getSortField() != null && !queryRequest.getSortField().equals("undefined")) {
			pageField = queryRequest.getSortField();
		}
		Sort sort = new Sort(pageOrder, pageField);
		//System.out.println("order=>" + pageOrder + ", field=>" + pageField);
        return this.menuService.findMenus(sort, menu);
    }

    /*@GetMapping
    @RequiresPermissions("menu:view")
    public Map<String, Object> menuList(Menu menu) {
        return this.menuService.findMenus(menu);
    }

    @Log("新增菜单/按钮")
    @PostMapping
    @RequiresPermissions("menu:add")
    public void addMenu(@Valid Menu menu) throws FebsException {
        try {
            this.menuService.createMenu(menu);
        } catch (Exception e) {
            message = "新增菜单/按钮失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("删除菜单/按钮")
    @DeleteMapping("/{menuIds}")
    @RequiresPermissions("menu:delete")
    public void deleteMenus(@NotBlank(message = "{required}") @PathVariable String menuIds) throws FebsException {
        try {
            String[] ids = menuIds.split(StringPool.COMMA);
            Long[] lids = new Long[ids.length];
            for (int i = 0; i < ids.length; i++) {
				lids[i] = Long.valueOf(ids[i]);
			}
            this.menuService.deleteMeuns(lids);
        } catch (Exception e) {
            message = "删除菜单/按钮失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @Log("修改菜单/按钮")
    @PutMapping
    @RequiresPermissions("menu:update")
    public void updateMenu(@Valid Menu menu) throws FebsException {
        try {
            this.menuService.updateMenu(menu);
        } catch (Exception e) {
            message = "修改菜单/按钮失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PostMapping("excel")
    @RequiresPermissions("menu:export")
    public void export(Menu menu, HttpServletResponse response) throws FebsException {
        try {
            List<Menu> menus = this.menuService.findMenuList(menu);
            ExcelKit.$Export(Menu.class, response).downXlsx(menus, false);
        } catch (Exception e) {
            message = "导出Excel失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }*/
}
