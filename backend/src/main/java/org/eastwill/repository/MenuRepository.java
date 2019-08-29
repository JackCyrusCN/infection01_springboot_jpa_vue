package org.eastwill.repository;

import java.util.List;

import org.eastwill.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(timeout=15)
public interface MenuRepository extends JpaRepository<Menu, Long>{
	
	//@Query(value="select * from t_menu where menu_id in (select menu_id from t_role_menu = 1?)",nativeQuery=true)
	@Query(value = "select distinct '\"'||m.perms ||'\"' from t_role r "
			+ "left join t_user_role ur on (r.role_id = ur.role_id) "
			+ "left join t_user u on (u.user_id = ur.user_id) "
			+ "left join t_role_menu rm on (rm.role_id = r.role_id) "
			+ "left join t_menu m on (m.menu_id = rm.menu_id) "
			+ "where u.username = ?1 and m.type <> '1' "
			+ "and m.perms is not null and m.perms <> ''", nativeQuery = true)
	List<String> findUserPermissions(String username);
	
	@Query(value = "select distinct '\"'||m.perms ||'\"' from t_role r "
			+ "left join t_user_role ur on (r.role_id = ur.role_id) "
			+ "left join t_user u on (u.user_id = ur.user_id) "
			+ "left join t_role_menu rm on (rm.role_id = r.role_id) "
			+ "left join t_menu m on (m.menu_id = rm.menu_id) "
			+ "where u.username = ?1 and m.type = '1' "
			+ "and m.perms is not null and m.perms <> ''", nativeQuery = true)
	List<String> findUserActions(String username);
	
	@Query(value = "select m.* from t_menu m" + 
			" where m.type <> '1'" + 
			" and m.MENU_ID in" + 
			" (select distinct rm.menu_id" + 
			" from t_role_menu rm" + 
			" left join t_role r on (rm.role_id = r.role_id)" + 
			" left join t_user_role ur on (ur.role_id = r.role_id)" + 
			" left join t_user u on (u.user_id = ur.user_id)" + 
			" where u.username = ?1)" + 
			" order by m.order_num", nativeQuery = true)
	List<Menu> findUserMenus(String username);
	
	
}
