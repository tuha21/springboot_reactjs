package com.fpt.service.impl;

import com.fpt.dto.OrderDTO;
import com.fpt.dto.OrderDetailDTO;
import com.fpt.entity.Order;
import com.fpt.entity.OrderDetail;
import com.fpt.mapper.OrderDetailMapper;
import com.fpt.repo.OrderDetailRepo;
import com.fpt.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetailDTO> findByOrder(Order order) {
        List<OrderDetail> listEntity = this.orderDetailRepo.findByOrder(order);
        if(!listEntity.isEmpty()){
            return listEntity.stream()
                    .map(entity -> this.orderDetailMapper.crvToDTO(entity))
                    .collect(Collectors.toList());
        }
        else return null;
    }

    @Override
    public OrderDetailDTO create(OrderDetailDTO orderDetailDTO) {
        return this.orderDetailMapper.crvToDTO(this.orderDetailRepo.save(this.orderDetailMapper.crvToEntity(orderDetailDTO)));
    }

}
