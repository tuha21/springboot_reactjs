package com.fpt.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpt.dto.CustomUserDetail;
import com.fpt.dto.Profile;
import com.fpt.entity.Account;
import com.fpt.jwt.JwtHelper;
import com.fpt.repo.AccountRepo;
import com.fpt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	AccountService accountService;
	@Autowired
	private AccountRepo accountRepo;

	@GetMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) throws JsonProcessingException {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtHelper.generateTJwtToken((CustomUserDetail) authentication.getPrincipal());
		return jwt;
	}


	@GetMapping("/getProfile")
	public ResponseEntity<Profile> getProfile (HttpServletRequest request) throws JsonProcessingException {
		String jwtToken = request.getHeader("Authorization");
		String username = jwtHelper.getUsernameFromJwt(jwtToken.substring(7));
		Account account = accountRepo.findByUsername(username);
		List<Integer> roles = account.getAuthorities().stream()
				.map(authority -> authority.getRole().getId())
				.collect(Collectors.toList());
		Profile profile = new Profile();
		profile.setId(account.getId());
		profile.setFullName(account.getFullname());
		profile.setUsername(account.getUsername());
		profile.setPhoto(account.getPhoto());
		profile.setEmail(account.getEmail());
		profile.setRoles(roles);
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}

	@GetMapping("/staff")
	public ResponseEntity<HttpStatus> isStaff() {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
