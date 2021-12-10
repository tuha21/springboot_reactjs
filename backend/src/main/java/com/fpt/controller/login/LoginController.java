package com.fpt.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpt.dto.CustomUserDetail;
import com.fpt.dto.Profile;
import com.fpt.dto.request.ChangeAvatar;
import com.fpt.dto.request.ChangePassword;
import com.fpt.dto.request.ChangeProfile;
import com.fpt.dto.request.Signup;
import com.fpt.dto.response.MessageResponse;
import com.fpt.entity.Account;
import com.fpt.jwt.JwtHelper;
import com.fpt.repo.AccountRepo;
import com.fpt.service.AccountService;
import org.modelmapper.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.ErrorHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	PasswordEncoder encoder;

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

	@PostMapping("/signup")
	public ResponseEntity<String> registerAccount(@Valid @RequestBody Signup signup){
		if (accountRepo.existsByUsername(signup.getUsername())){
			return new ResponseEntity<>("Error: Username is already taken!",HttpStatus.BAD_REQUEST);
		}
		if (accountRepo.existsByEmail(signup.getEmail())){
			return new ResponseEntity<>("Error: Email is already in use!",HttpStatus.BAD_REQUEST);
		}
		if (signup.getPhoto()==""){
			signup.setPhoto("https://firebasestorage.googleapis.com/v0/b/chinhbeo-18d3b.appspot.com/o/avatar.png?alt=media&token=3511cf81-8df2-4483-82a8-17becfd03211");
		}

		Account account = new Account(signup.getUsername(),
				encoder.encode(signup.getPassword()),
				signup.getFullname(),
				signup.getEmail(),
				signup.getPhoto(),
				signup.getStatus()
				);
		accountRepo.save(account);
		return new ResponseEntity<>("Account registered successfully!",HttpStatus.OK);
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

	@PutMapping("/changePassword")
	public ResponseEntity<Object> changePassword(HttpServletRequest request, @Valid @RequestBody ChangePassword changePassword){
		String jwt = jwtHelper.parseJwt(request);
		String username = jwtHelper.getUsernameFromJwt(jwt);
		Account account;
		try {
			account = accountRepo.findByUsername(username);
			if (account==null){
				return new ResponseEntity<>("User Not Found with -> username"+username,HttpStatus.OK);
			}
			boolean matches = encoder.matches(changePassword.getCurrentPassword(),account.getPassword());
			if (changePassword.getNewPassword()!=null){
				if (matches){
					account.setPassword(encoder.encode(changePassword.getNewPassword()));
					accountRepo.save(account);
				}else{
					return new ResponseEntity<>(new MessageResponse("Password change failed"),HttpStatus.OK);
				}
			}
			return new ResponseEntity<>(new MessageResponse("Change password successfully"),HttpStatus.OK);
		}catch (UsernameNotFoundException e){
			return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/changeProfile")
	public ResponseEntity<Object> changProfile(HttpServletRequest request,@Valid @RequestBody ChangeProfile changeProfile){
		String jwt = jwtHelper.parseJwt(request);
		String username= jwtHelper.getUsernameFromJwt(jwt);
		Account account;
		try {
			account = accountRepo.findByUsername(username);
			//			if (account==null){
//				return new ResponseEntity<>("User Not Found with -> username"+username,HttpStatus.OK);
//			}
			if (changeProfile.getEmail().equals(account.getEmail())){
					account.setEmail(changeProfile.getEmail());
			}
			if (!changeProfile.getEmail().equals(account.getEmail())){
				if (accountRepo.existsByEmail(changeProfile.getEmail())){
					return new ResponseEntity<>(new MessageResponse("Email is exist!"), HttpStatus.OK);
				}
				account.setEmail(changeProfile.getEmail());
			}
			account.setFullname(changeProfile.getFullname());
			account.setEmail(changeProfile.getEmail());
			account.setPhoto(changeProfile.getPhoto());
			accountRepo.save(account);
			return new ResponseEntity<>(new MessageResponse("Change success"), HttpStatus.OK);
		} catch (UsernameNotFoundException e){
			return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.NOT_FOUND );
		}
	}

	@PutMapping("/changeAvatar")
	public ResponseEntity<Object> changeAvatar(HttpServletRequest request, @Valid @RequestBody ChangeAvatar changeAvatar){
		String jwt = jwtHelper.parseJwt(request);
		String username= jwtHelper.getUsernameFromJwt(jwt);
		Account account;
		try {
			if (changeAvatar.getAvatar()==null){
				return new ResponseEntity<>(new MessageResponse("No success"), HttpStatus.OK);
			}else {
				account = accountRepo.findByUsername(username);
				if (account==null){
					return new ResponseEntity<>("User Not Found with -> username"+username,HttpStatus.OK);
				}
				account.setPhoto(changeAvatar.getAvatar());
				accountRepo.save(account);
			}
			return new ResponseEntity<>(new MessageResponse("Change success"),HttpStatus.OK);
		}catch (UsernameNotFoundException e){
			return new ResponseEntity<>(new MessageResponse(e.getMessage()),HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/staff")
	public ResponseEntity<HttpStatus> isStaff() {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
