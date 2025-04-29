package com.dev.ecom.repositories;

import com.dev.ecom.model.Category;
import com.dev.ecom.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryOrderByPriceAsc(Pageable pageDetails, Category category);

    Page<Product> findByProductNameLikeIgnoreCase(Pageable pageDetails, String keyword);
}
