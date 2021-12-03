package com.fpt.repo;

import com.fpt.entity.Product;
import com.fpt.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepo extends JpaRepository<ProductDetail, Integer> {

//    @Query(value = "select distinct a.size from j6shop.product_details a where a.product_id = ?1",nativeQuery = true)
//    List<ProductDetail> findAllSizeByProductId(Product productId);

    //Lấy toàn bộ color khác nhau theo product_id
//    @Query("select distinct p.color from ProductDetail p where p.productId=?1")
    @Query(value = "select distinct a.color from j6shop.product_details a where a.product_id = ?1",nativeQuery = true)
    List<String> findColorDistinctByProductId(Integer product);

    //Lấy toàn bộ color khác nhau theo product_id
    @Query("select distinct p.color from ProductDetail p where p.productId =?1 and p.size=?2")
    List<String> findDistinctByProductIdAndSize(Product product,String size);

    // Lấy toàn bộ size và color
    @Query(value = "select distinct b.size,b.color from j6shop.product_details b where b.product_id =?1",nativeQuery = true)
    List<String> getAllSizeAndColor(Integer productId);

    // Lấy toàn bộ color khác nhau theo product_id
//    @Query("select distinct  p.size from ProductDetail p where p.productId=?1")
    @Query(value = "select distinct a.size from j6shop.product_details a where a.product_id = ?1",nativeQuery = true)
    List<String> findSizeDistinctByProductId(Integer product);

    List<ProductDetail> findDistinctByProductId(Product productId);

    List<ProductDetail> findByProductId(Product productId);
    List<ProductDetail> findByProductIdAndColor(Product productId, String color);
    List<ProductDetail> findByProductIdAndSize(Product productId, String size);
    List<ProductDetail> findByProductIdAndColorAndSize(Product productId, String color, String size);



}
