package com.fpt.controller.guest;

import com.fpt.dto.ProductDetailDTO;
import com.fpt.entity.Product;
import com.fpt.mapper.ProductMapper;
import com.fpt.service.ProductDetailService;
import com.fpt.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/guest/productdetail")
public class ProductDetailController {

    final
    ProductDetailService productDetailService;

    final
    ProductService productService;

    final
    ProductMapper productMapper;

    public ProductDetailController(ProductDetailService productDetailService, ProductService productService, ProductMapper productMapper) {
        this.productDetailService = productDetailService;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ResponseEntity<ProductDetailDTO> create(@RequestBody ProductDetailDTO ProductDetailDTO) {
        ProductDetailDTO productDetailDTOS = productDetailService.create(ProductDetailDTO);
        return new ResponseEntity<ProductDetailDTO>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDetailDTO> update(@RequestBody ProductDetailDTO productDetailDTO) {
        ProductDetailDTO productDetailDTO1 = productDetailService.update(productDetailDTO);
        return new ResponseEntity<ProductDetailDTO>(HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<ProductDetailDTO> delete(@RequestBody ProductDetailDTO productDetailDTO) {
        if (productDetailService.findById(productDetailDTO.getId()) == null) {
            return new ResponseEntity<ProductDetailDTO>(HttpStatus.NOT_FOUND);
        }
        ProductDetailDTO productDetailDTO1 = productDetailService.delete(productDetailDTO);
        return new ResponseEntity<ProductDetailDTO>(HttpStatus.OK);
    }

}
