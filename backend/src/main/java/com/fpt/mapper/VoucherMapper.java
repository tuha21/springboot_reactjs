package com.fpt.mapper;

import com.fpt.dto.VoucherDTO;
import com.fpt.entity.Order;
import com.fpt.entity.Voucher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoucherMapper {
    @Autowired
    ModelMapper mapper;

    public VoucherDTO voucherDTO(Order entity) {
        VoucherDTO dto = new VoucherDTO();
        mapper.map(entity, dto);
        return dto;
    }

    public Voucher voucher(VoucherDTO dto) {
        Voucher entity = new Voucher();
        mapper.map(dto, entity);
        return entity;
    }
}
