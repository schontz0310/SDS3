package com.devsuperor.dsvendas.services;

import com.devsuperor.dsvendas.dto.SaleDTO;
import com.devsuperor.dsvendas.dto.SalesSuccessDTO;
import com.devsuperor.dsvendas.dto.SalesSumDTO;
import com.devsuperor.dsvendas.entities.Sale;
import com.devsuperor.dsvendas.repositories.SaleRepository;
import com.devsuperor.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        sellerRepository.findAll();
        Page<Sale> result = saleRepository.findAll(pageable);
        return result.map( sale -> new SaleDTO(sale));
    }

    @Transactional(readOnly = true)
    public List<SalesSumDTO> amountGroupedBySeller(){
       return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SalesSuccessDTO> successGroupedBySeller(){
        return saleRepository.successGroupedBySeller();
    }

}
