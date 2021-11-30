package com.fpt.controller.guest;

import com.fpt.dto.ProductDetailDTO;
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

    @GetMapping("")
    public ResponseEntity<List<ProductDetailDTO>> findAll() {
        List<ProductDetailDTO> productDetailDTOS = productDetailService.findAll();
        if (productDetailDTOS.isEmpty()) {
            return new ResponseEntity<List<ProductDetailDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductDetailDTO>>(productDetailDTOS, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<ProductDetailDTO>> findByProductIdAndColorAndSize(
            @PathVariable("id") Optional<Integer> id,
            @RequestParam("color") Optional<String> color,
            @RequestParam("size") Optional<String> size) {
        List<ProductDetailDTO> productDetailDTOS = productDetailService.findByProductIdAndColorAndSize(
                productMapper.cvToEntity(productService.findById(id.get())), color.get(), size.get()
        );
        if (productDetailDTOS.isEmpty()) {
            return new ResponseEntity<List<ProductDetailDTO>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<ProductDetailDTO>>(HttpStatus.OK);
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
