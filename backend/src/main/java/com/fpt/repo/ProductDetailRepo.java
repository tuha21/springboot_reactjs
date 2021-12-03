package com.fpt.repo;

import com.fpt.dto.ProductDetailDTO;
import com.fpt.entity.Product;
import com.fpt.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepo extends JpaRepository<ProductDetail, Integer> {

    //    //lấy toàn bộ product_detail theo product_id
    @Query("select p from ProductDetail p where p.productId = ?1")
    List<ProductDetail> findByProductId(Integer productId);

    // lấy toàn bộ color khác nhau theo product_id
    @Query("select c.id, c.name, sum(pd.qty) as qty, count(pd.size_id) as size from colors c left join product_details pd on c.id = pd.color_id where product_id like '1' group by name")
    List<ProductDetailDTO> findProductDetailsByProduct(Product product);
}
