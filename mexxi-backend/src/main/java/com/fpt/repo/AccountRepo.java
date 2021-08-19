package com.fpt.repo;

import com.fpt.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer>{
	@Query("SELECT entity FROM Account entity WHERE entity.username=:username")
	public Account findByUsername(@Param("username") String username);
	
	@Query("SELECT entity FROM Account entity WHERE entity.username=:username and entity.status=1")
	public Account findActiveByUsername(@Param("username") String username);
	
	
	@Query("SELECT entity FROM  Account entity WHERE entity.username=:username and entity.password=:password and entity.status=1")
	public Account findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
