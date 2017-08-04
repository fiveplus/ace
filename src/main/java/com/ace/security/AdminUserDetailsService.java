package com.ace.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ace.entity.User;
import com.ace.service.UserService;

@Service
public class AdminUserDetailsService implements UserDetailsService{
	@Autowired
	private UserService userService;
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = null;
		try {
			user = userService.getUserToLoginName(userName);
		} catch (Exception e) {
			throw new UsernameNotFoundException("user select fail");
		}
		
		if(user == null){
			throw new UsernameNotFoundException("no user found");
		}else{
			try {
				String role = "ADMIN";
				return new AdminUserDetails(user, role);
			} catch (Exception e) {
				throw new UsernameNotFoundException("user role select fail");
			}
		}
	}
}
