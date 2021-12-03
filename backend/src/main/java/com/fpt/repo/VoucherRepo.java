package com.fpt.repo;


import com.fpt.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepo extends JpaRepository<Voucher, Integer> {

}
