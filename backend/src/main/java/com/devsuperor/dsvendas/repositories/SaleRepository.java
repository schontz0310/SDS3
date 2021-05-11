package com.devsuperor.dsvendas.repositories;

import com.devsuperor.dsvendas.dto.SalesSuccessDTO;
import com.devsuperor.dsvendas.dto.SalesSumDTO;
import com.devsuperor.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {


    @Query("SELECT new com.devsuperor.dsvendas.dto.SalesSumDTO(obj.seller, SUM(obj.amount)) " +
            " FROM Sale AS obj  GROUP BY obj.seller")
    List<SalesSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.devsuperor.dsvendas.dto.SalesSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
            " FROM Sale AS obj  GROUP BY obj.seller")
    List<SalesSuccessDTO> successGroupedBySeller();
}
