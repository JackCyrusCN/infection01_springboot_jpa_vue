package org.eastwill.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eastwill.domain.Dept;
import org.eastwill.pojo.Tree;
import org.eastwill.repository.DeptRepository;
import org.eastwill.service.DeptService;
import org.eastwill.util.TreeUtil;
import org.eastwill.web.controller.system.TokenController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptServiceImpl implements DeptService{
	
	private static Logger log = LoggerFactory.getLogger(TokenController.class);
	
	@Autowired
	private DeptRepository deptRepository;
	
	@Override
	public Map<String, Object> findDepts() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Dept> depts = deptRepository.findAll();
            List<Tree<Dept>> trees = new ArrayList<>();
            buildTrees(trees, depts);
            Tree<Dept> deptTree = TreeUtil.build(trees);

            result.put("rows", deptTree);
            result.put("total", depts.size());
        } catch (Exception e) {
            log.error("获取部门列表失败", e);
            result.put("rows", null);
            result.put("total", 0);
        }
        return result;
    }
	
	
	
	private void buildTrees(List<Tree<Dept>> trees, List<Dept> depts) {
        depts.forEach(dept -> {
            Tree<Dept> tree = new Tree<>();
            tree.setId(dept.getDeptId().toString());
            tree.setKey(tree.getId());
            tree.setParentId(dept.getParentId().toString());
            tree.setText(dept.getDeptName());
            tree.setCreateTime(dept.getCreateTime());
            tree.setModifyTime(dept.getModifyTime());
            tree.setOrder(dept.getOrderNum());
            tree.setTitle(tree.getText());
            tree.setValue(tree.getId());
            trees.add(tree);
        });
    }



	@Override
	@Transactional
	public void createDept(Dept dept) {
		// TODO Auto-generated method stub
		Long parentId = dept.getParentId();
        if (parentId == null)
            dept.setParentId(0L);
        dept.setCreateTime(new Date());
        deptRepository.save(dept);
	}

}
