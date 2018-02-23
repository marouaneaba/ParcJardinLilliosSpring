package com.lille1.parcsjardinslillois.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.lille1.parcsjardinslillois.entity.User;
import com.lille1.parcsjardinslillois.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service("CustomUserDetailService")
public class CustomUserDetails implements UserDetailsService {
	
	private static final Logger LOGGER = Logger.getLogger( CustomUserDetails.class.getName() );
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String s) {

		User user = null;

		try {

			user = userRepository.findByEmail(s);

		} catch (UsernameNotFoundException e) {
			LOGGER.log(Level.FINE,"erreur : ",e);
		}

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true,
				true, true, authorities);
	}

}
