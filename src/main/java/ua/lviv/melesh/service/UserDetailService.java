package ua.lviv.melesh.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService {

	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException;

}
