package com.devsuperor.dsvendas.repositories;

import com.devsuperor.dsvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository  extends JpaRepository<Seller, Long> {
}
