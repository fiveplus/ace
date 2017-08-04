package com.ace.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ace.config.ServerConfig;
import com.ace.controller.admin.bo.PermissionBO;
import com.ace.entity.Permission;
import com.ace.entity.User;
import com.ace.service.PermissionService;
import com.ace.service.UserService;
import com.ace.util.Resource;

public class AdminInterceptor implements HandlerInterceptor{
	
	@Autowired
	private ServerConfig serverConfig;
	
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		//处理请求内容前
		String parentId = request.getParameter("parentId");
		if(parentId == null) parentId = "";
		session.setAttribute("parentId", parentId);
		
		//菜单组装
		String loginName = request.getRemoteUser();
		//TODO 组装权限
		if(loginName != null && !loginName.equals("")){
			List<PermissionBO> pbos = new ArrayList<PermissionBO>();
			User user = userService.getUserToLoginName(loginName);
			if(null != user){
				int groupId = user.getGroupId();
				if(groupId > 0){
					List<Permission> parentMenu = permissionService.getParentMenu();
					List<Permission> pers = permissionService
							.getChildPermissionByUserId(user.getId());
					// TODO 无权从部门权限里加载
					if (pers == null || (pers != null && pers.size() == 0)) {
						pers = permissionService
								.getChildPermissionByGroupId(groupId);
					}
					for (Permission menu : parentMenu) {
						PermissionBO pbo = new PermissionBO();
						pbo.setPermission(menu);
						pbo.setPers(new ArrayList<Permission>());
						pbos.add(pbo);
					}
					for (PermissionBO pbo : pbos) {
						for (Permission per : pers) {
							if (per.getParentId().equals(
									pbo.getPermission().getId())
									&& per.getIsMenu().equals("Y")) {
								pbo.getPers().add(per);
							}
						}
					}
					// 反向遍历清除空元素
					for (int i = pbos.size() - 1; i >= 0; i--) {
						PermissionBO pbo = pbos.get(i);
						if (pbo.getPers() == null || pbo.getPers().size() == 0) {
							pbos.remove(pbo);
						}
					}
					// 用户设权
					user.setPers(pers);
				}
			}
			request.setAttribute("user", user);
			request.setAttribute("menus", pbos);
		}
		
		
		//TODO 确认模板页main填充路径  /admin/permission/list/1
		String finder = "";
		String mainName = "main";
		try{
			String uri = request.getRequestURI();
			int index = uri.indexOf(Resource.ADMIN);
			if(index >= 0){
				index += Resource.ADMIN.length();
				String turi = uri.substring(index+1);
				if(!turi.equals("")){
					finder = turi.substring(0,turi.indexOf("/"));
					finder = "/"+finder;
					turi = turi.substring(turi.indexOf("/")+1);
					mainName = turi.substring(0,turi.indexOf("/") < 0 ? turi.length() : turi.indexOf("/"));
				}
			}
		}catch(Exception e){}
		
		
		request.setAttribute("url", "admin"+finder+"/"+mainName);
		
		request.setAttribute("contextPath", contextPath);
		request.setAttribute("company", serverConfig.getCompany());
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		//View渲染前调用
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	}
	
	
	
	
	
}
