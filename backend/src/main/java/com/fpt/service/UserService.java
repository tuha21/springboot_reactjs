package com.fpt.service;

import com.fpt.entity.Account;
import com.fpt.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	BCryptPasswordEncoder be;
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account account = this.accountService.findActiveByUsername(username);
			String password = account.getPassword();
			String[] roles = account.getAuthorities().stream()
					.map(au -> au.getRole().getName())
					.collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username)
					.password(be.encode(password))
					.roles(roles)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Not found account: " + username);
		}
	}

}
