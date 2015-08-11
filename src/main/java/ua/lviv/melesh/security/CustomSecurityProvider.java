package ua.lviv.melesh.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import ua.lviv.melesh.domain.User;
import ua.lviv.melesh.service.UserService;

@Service("customAuthenticationProvider")
public class CustomSecurityProvider implements AuthenticationProvider {

	@Autowired
	private UserService uService;

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		System.out.println("Authenticate");
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		User dbUser = uService.getUserByName(username);

		if (username.equals(dbUser.getName()) && password == dbUser.getPassword()) {
			if (dbUser.getRole() == "ROLE_ADMIN") {
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			} else {
				System.out.println("else1");
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			}

		} else {
			System.out.println("else");
			return null;
		}
		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}

}