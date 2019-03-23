package com.ivo.Task2.modelmapper.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("serial")
public class CustomUserDetails extends User implements UserDetails {

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	public CustomUserDetails(final User user) {
		super(user);
	}
	
	//Get the role of logged in user
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getRoles() .stream() .map(role-> new SimpleGrantedAuthority("ROLE_"+role.getRole())).collect(Collectors.toList());
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
		if(super.getActive()==1) {
		return true;
		}
		else return false;
	}
	
}
