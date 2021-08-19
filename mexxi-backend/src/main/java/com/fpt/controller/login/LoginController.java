package com.fpt.controller.login;

import com.fpt.dto.AccountDTO;
import com.fpt.dto.UserDetail;
import com.fpt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

	@Autowired
	AccountService accountService;

	@GetMapping("/login")
	public ResponseEntity<UserDetail> login(@RequestParam("username") String username, @RequestParam("password") String password) {
		UserDetail userDetail =accountService.findByUsernameAndPassword(username, password);
		if(userDetail != null) {
			return new ResponseEntity<UserDetail>(userDetail, HttpStatus.OK);
		}
		return new ResponseEntity<UserDetail>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/staff")
	public ResponseEntity<HttpStatus> isStaff() {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
