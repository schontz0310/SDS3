package com.devsuperor.dsvendas.controllers;


import com.devsuperor.dsvendas.dto.SaleDTO;
import com.devsuperor.dsvendas.dto.SalesSuccessDTO;
import com.devsuperor.dsvendas.dto.SalesSumDTO;
import com.devsuperor.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        Page<SaleDTO> result = saleService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SalesSumDTO>> amountGroupedBySeller(){
        List<SalesSumDTO> result = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SalesSuccessDTO>> successGroupedBySeller(){
        List<SalesSuccessDTO> result = saleService.successGroupedBySeller();
        return ResponseEntity.ok(result);
    }
}

