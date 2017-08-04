package com.ace.controller.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ace.controller.admin.bo.AdditionalParameters;
import com.ace.controller.admin.bo.Item;
import com.ace.controller.admin.bo.TreeRespBO;
import com.ace.entity.Group;
import com.ace.entity.GroupPermission;
import com.ace.entity.Permission;
import com.ace.service.GroupPermissionService;
import com.ace.service.GroupService;
import com.ace.service.PermissionService;
import com.ace.util.PageCode;
import com.ace.util.StringUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/admin/group")
public class GroupAdminController extends BaseController{
	@Autowired
	private GroupService groupService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private GroupPermissionService groupPermissionService;
	
	@RequestMapping("/list/{page}")
	public String list(@PathVariable int page,HttpServletRequest request,Model model){
		PageInfo<Group> pu = groupService.queryPageListByWhere(null, page, PAGESIZE);
		PageCode pc = new PageCode(page, pu.getPages());
		model.addAttribute("pu", pu);
		model.addAttribute("pc", pc);
		return INDEX;
	}
	
	@RequestMapping("/select/{id}")
	public String select(@PathVariable int id,HttpServletRequest request,Model model){
		Group group = groupService.queryById(id);
		model.addAttribute("group",group);
		return INDEX;
	}
	
	@RequestMapping("/upt/{id}")
	public String upt(@PathVariable int id,HttpServletRequest request,Model model){
		Group group = groupService.queryById(id);
		model.addAttribute("group",group);
		return INDEX;
	}
	
	@RequestMapping("/update")
	public @ResponseBody Map<String,Object> update(Group group,HttpServletRequest request,Model model){
		Map<String,Object> returnMap = new HashMap<String, Object>();
		Group g = groupService.queryByName(group.getName());
		if(g == null || (g != null && group.getName().equals(g.getName()))){
			int count = groupService.updateSelective(group);
			if(count > 0){
				returnMap.put("msg", "成功！很好地完成了提交。");
				returnMap.put("code", 0);
			}else{
				returnMap.put("msg", "错误！请进行一些更改。");
				returnMap.put("code", 4);
			}
		}else{
			returnMap.put("msg", "错误！组名称已存在。");
			returnMap.put("code", 4);
		}
		return returnMap;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Model model){
		return INDEX;
	}
	
	@RequestMapping("/save")
	public @ResponseBody Map<String,Object> save(Group group,HttpServletRequest request,Model model){
		Map<String,Object> returnMap = new HashMap<String, Object>();
		Group g = groupService.queryByName(group.getName());
		if(g == null || (g != null && group.getName().equals(g.getName()))){
			group.setCreateTime(StringUtils.getDateToLong(new Date()));
			int count = groupService.saveSelect(group);
			if(count > 0){
				returnMap.put("msg", "成功！很好地完成了提交。");
				returnMap.put("code", 0);
			}else{
				returnMap.put("msg", "错误！请进行一些更改。");
				returnMap.put("code", 4);
			}
		}else{
			returnMap.put("msg", "错误！组名称已存在。");
			returnMap.put("code", 4);
		}
		return returnMap;
	}
	
	@RequestMapping("/perlist/{id}")
	public String perlist(@PathVariable int id,HttpServletRequest request,Model model){
		Group group =groupService.queryById(id);
		model.addAttribute("group",group);
		return INDEX;
	}
	
	@RequestMapping("/perlist.json")
	public @ResponseBody TreeRespBO perlist_json(String pid,int did,HttpServletRequest request,Model model){
		List<Permission> perlist = permissionService.getChildPermissionByGroupId(did);
		List<Permission> list = permissionService.getPermissionByParentId(pid);
		TreeRespBO tree = new TreeRespBO();
		List<Item> boItemList = new ArrayList<Item>();
		if(null != list && list.size() > 0){
			for(Permission p:list){
				Item item = new Item();
				//查询子节点数量
				int child_count = permissionService.getCountByParentId(p.getId());
				item.setName(p.getName());
				if(child_count > 0){
					item.setType("folder");
					AdditionalParameters adp = new AdditionalParameters();
					adp.setId(p.getId());
					item.setAdditionalParameters(adp);
				}else{
					AdditionalParameters adp = new AdditionalParameters();
					adp.setId(p.getId());
					item.setAdditionalParameters(adp);
					for(Permission per:perlist){
						if(per.getId().equals(p.getId())){
							adp.setItemSeleted(true);
							break;
						}
					}
					
					item.setType("item");
				}
				boItemList.add(item);
			}
		}
		tree.setData(boItemList);
		tree.setStatus("OK");
		return tree;		
	}
	
	@RequestMapping("/savepers")
	public @ResponseBody Map<String,Object> savepers(int did,String pids,HttpServletRequest request,Model model){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		//权限清除
		groupPermissionService.deletePermissionByGroupId(did);
		if(pids != null && !pids.equals("")){
			//权限保存
			String[] ids = pids.split(",");
			for(String id:ids){
				GroupPermission gp = new GroupPermission();
				gp.setGroupId(did);
				gp.setPermissionId(id);
				int count = groupPermissionService.saveSelect(gp);
			}
		}
		returnMap.put("code", 0);
		returnMap.put("msg", "成功！很好地完成了提交。");
		
		return returnMap;
	}
	
	
}
