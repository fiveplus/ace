package com.ace.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.ace.entity.User;

public class AdminUserDetails extends User implements UserDetails{

	private String role;
	
	public AdminUserDetails(User user,String role){
		super(user);
		this.role = role;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		StringBuilder commaBuilder = new StringBuilder();
		commaBuilder.append(role);
		String authorities = commaBuilder.toString();
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
	}

	@Override
	public String getUsername() {
		return super.getLoginName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String getPassword() {
		return super.getPassword();
	}
	
}
