package com.productRest.app.resository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.productRest.app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByName(String name);

	@Query("SELECT p FROM Product p ORDER BY p.id DESC")
	List<Product> findDesc(Product product);
	
//	@Query("SELECT TOP 3 * FROM Product p order by p.id asc")
//	List<Product>findTop3(Pageable pageable);

}
