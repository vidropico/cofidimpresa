package it.cofidimpresa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.cofidimpresa.datamodel.UserModel;

public class MyUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserModel user;
	 
	public MyUserDetails(UserModel user) {
	      this.user = user;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<GrantedAuthority> list = new HashSet<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(user.getRole()));

        return list;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	public String getUsername() {
		return user.getUserid();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
