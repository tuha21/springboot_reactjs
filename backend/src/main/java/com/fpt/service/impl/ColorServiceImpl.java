package com.fpt.service.impl;

import com.fpt.dto.ProductDetailDTO;
import com.fpt.entity.Color;
import com.fpt.repo.ColorRepo;
import com.fpt.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService {

    final ColorRepo colorRepo;

    public ColorServiceImpl(ColorRepo colorRepo) {
        this.colorRepo = colorRepo;
    }

}
