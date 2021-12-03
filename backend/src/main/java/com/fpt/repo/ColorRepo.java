package com.fpt.repo;

import com.fpt.dto.ProductDetailDTO;
import com.fpt.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepo extends JpaRepository<Color, Integer> {

}
