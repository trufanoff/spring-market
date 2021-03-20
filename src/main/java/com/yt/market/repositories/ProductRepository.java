package com.yt.market.repositories;

import com.yt.market.dto.ProductDto;
import com.yt.market.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Optional<ProductDto> findOneById(Long id);

    List<Product> findByPriceGreaterThanEqual(Integer price);
}
