package com.fpt.service;

import com.fpt.dto.AccountDTO;
import com.fpt.dto.UserDetail;
import com.fpt.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface AccountService {
	
	public List<AccountDTO> findAll();
	
	public AccountDTO findById(Integer id);
	
	public AccountDTO create(AccountDTO dto);
	
	public AccountDTO update(AccountDTO dto);
	
	public AccountDTO delete(Integer id);
	
	public boolean isExist(String username);
	
	public Account findActiveByUsername(String username);
	
	public UserDetail findByUsernameAndPassword(String username, String password);
}
