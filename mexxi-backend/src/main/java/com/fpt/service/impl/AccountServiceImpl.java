package com.fpt.service.impl;

import com.fpt.dto.AccountDTO;
import com.fpt.dto.UserDetail;
import com.fpt.entity.Account;
import com.fpt.mapper.AccountMapper;
import com.fpt.repo.AccountRepo;
import com.fpt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	AccountMapper accountMapper;
	
	@Override
	public List<AccountDTO> findAll() {
		return this.accountRepo.findAll().stream()
				.map(entity -> this.accountMapper.cvToDTO(entity))
				.collect(Collectors.toList());
	}

	@Override
	public AccountDTO findById(Integer id) {
		return this.accountMapper.cvToDTO(this.accountRepo.findById(id).get());
	}

	@Override
	public AccountDTO create(AccountDTO dto) {
		return this.accountMapper.cvToDTO(this.accountRepo.save(this.accountMapper.cvToEntity(dto)));
	}

	@Override
	public AccountDTO update(AccountDTO dto) {
		return this.accountMapper.cvToDTO(this.accountRepo.save(this.accountMapper.cvToEntity(dto)));
	}

	@Override
	public AccountDTO delete(Integer id) {
		Account account = this.accountRepo.findById(id).get();
		this.accountRepo.delete(account);
		return this.accountMapper.cvToDTO(account);
	}

	@Override
	public boolean isExist(String username) {
		Account account = accountRepo.findByUsername(username);
		if(account == null) {
			return false;
		}
		return true;
	}

	@Override
	public Account findActiveByUsername(String username) {
		return this.accountRepo.findActiveByUsername(username);
	}

	@Override
	public UserDetail findByUsernameAndPassword(String username, String password) {
		Optional<Account> entity = Optional.ofNullable(accountRepo.findByUsernameAndPassword(username, password));
		List<Integer> roles = entity.get().getAuthorities().stream()
				.map(authority -> authority.getRole().getId())
				.collect(Collectors.toList());
		if(entity.isPresent()) {
			UserDetail userDetail = new UserDetail(entity.get().getId(),entity.get().getUsername(), entity.get().getPassword(),roles);
			return userDetail;
//			return this.accountMapper.cvToDTO(entity.get());
		}
		return null;
	}
}
