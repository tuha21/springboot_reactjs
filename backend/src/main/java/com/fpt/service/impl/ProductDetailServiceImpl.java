package com.fpt.service.impl;

import com.fpt.dto.ColorDTO;
import com.fpt.dto.ProductDetailDTO;
import com.fpt.entity.Product;
import com.fpt.mapper.ProductDetailMapper;
import com.fpt.repo.ProductDetailRepo;
import com.fpt.repo.ProductRepo;
import com.fpt.service.ProductDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    final
    ProductDetailRepo productDetailRepo;

    final
    ProductDetailMapper productDetailMapper;

    final
    ProductRepo productRepo;

    public ProductDetailServiceImpl(ProductDetailRepo productDetailRepo, ProductRepo productRepo, ProductDetailMapper productDetailMapper) {
        this.productDetailRepo = productDetailRepo;
        this.productRepo = productRepo;
        this.productDetailMapper = productDetailMapper;
    }

    @Override
    public List<ProductDetailDTO> findAll() {
        return productDetailRepo.findAll().stream()
                .map(productDetailMapper::cvrToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDetailDTO> findByProductId(Product productId) {
        return productDetailRepo.findByProductId(productId).stream()
                .map(productDetailMapper::cvrToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDetailDTO> findByProductIdAndColor(Product productId, String color) {
        return productDetailRepo.findByProductIdAndColor(productId, color).stream()
                .map(productDetailMapper::cvrToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDetailDTO> findByProductIdAndSize(Product productId, String size) {
        return productDetailRepo.findByProductIdAndSize(productId, size).stream()
                .map(productDetailMapper::cvrToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDetailDTO> findByProductIdAndColorAndSize(Product productId, String color, String size) {
        return productDetailRepo.findByProductIdAndColorAndSize(productId, color, size).stream()
                .map(productDetailMapper::cvrToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDetailDTO findById(Integer id) {
        return productDetailMapper.cvrToDTO(productDetailRepo.findById(id).get());
    }

    @Override
    public ProductDetailDTO create(ProductDetailDTO dto) {
        return productDetailMapper.cvrToDTO(productDetailRepo.save(productDetailMapper.cvrToEntity(dto)));
    }

    @Override
    public ProductDetailDTO update(ProductDetailDTO dto) {
        return productDetailMapper.cvrToDTO(productDetailRepo.save(productDetailMapper.cvrToEntity(dto)));
    }

    @Override
    public ProductDetailDTO delete(ProductDetailDTO dto) {
        productDetailRepo.delete(productDetailMapper.cvrToEntity(dto));
        return dto;
    }
}
