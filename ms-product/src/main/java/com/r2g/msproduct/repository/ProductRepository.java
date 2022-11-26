package com.r2g.msproduct.repository;

import com.r2g.msproduct.entity.Category;
import com.r2g.msproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public List<Product> findByCategory(Category category);

}
