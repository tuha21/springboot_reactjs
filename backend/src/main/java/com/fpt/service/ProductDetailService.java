package com.fpt.service;

import com.fpt.dto.ProductDetailDTO;
import com.fpt.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductDetailService {

    List<ProductDetailDTO> findAll();

    List<ProductDetailDTO> findByProductId(Product productId);

    List<ProductDetailDTO> findByProductIdAndColor(Product productId, String color);

    List<ProductDetailDTO> findByProductIdAndSize(Product productId, String size);

    List<ProductDetailDTO> findByProductIdAndColorAndSize(Product productId, String color, String size);

    ProductDetailDTO create(ProductDetailDTO dto);

    ProductDetailDTO update(ProductDetailDTO dto);

    ProductDetailDTO delete(ProductDetailDTO dto);

}
