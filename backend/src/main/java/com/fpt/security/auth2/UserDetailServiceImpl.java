package com.fpt.security.auth2;

import com.fpt.entity.Account;
import com.fpt.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepo.findByEmail(email);
        if (account==null){
            throw new UsernameNotFoundException("Account not found");
        }
        return (UserDetails) UserPrincipal.create(account);
    }
}
