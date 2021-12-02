package com.fpt.repo;

import com.fpt.entity.Product;
import com.fpt.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepo extends JpaRepository<ProductDetail, Integer> {
    List<ProductDetail> findByProductId(Product productId);
    List<ProductDetail> findByProductIdAndColor(Product productId, String color);
    List<ProductDetail> findByProductIdAndSize(Product productId, String size);
    List<ProductDetail> findByProductIdAndColorAndSize(Product productId, String color, String size);
}
