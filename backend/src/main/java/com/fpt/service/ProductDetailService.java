package com.fpt.service;

import com.fpt.dto.ProductDetailDTO;
import com.fpt.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductDetailService {

    List<ProductDetailDTO> findAll();

    ProductDetailDTO findById(Integer id);

    List<ProductDetailDTO> findByProductId(Integer productId);

    List<String> findDistinctByProductId(Integer productId);

    ProductDetailDTO create(ProductDetailDTO dto);

    ProductDetailDTO update(ProductDetailDTO dto);

    ProductDetailDTO delete(ProductDetailDTO dto);

}
