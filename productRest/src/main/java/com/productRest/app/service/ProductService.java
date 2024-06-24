package com.productRest.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.productRest.app.model.Product;
import com.productRest.app.resository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product product) {
	return	productRepository.save(product);
		
	}
	
	public  List<Product>findAll(){
	return	productRepository.findAll();
	}
	
	public Optional findById(int id) {
	Optional<Product>op=productRepository.findById(id);
	op.isPresent();
	return op;
	}
	
	public void remove(int id) {
	
		productRepository.deleteById( id);
	}
	
	public long countAll() {
		return productRepository.count();
	}
	
	public List<Product>findByName(String name){
		return productRepository.findByName(name);
	}
	
	

	public List<Product> findDesc(Product product) {
		return productRepository.findDesc(product);
		
	}
	
//	public List<Product>findTop3(Product product){
//		Pageable topThree=PageRequest.of(0, 3);
//		return productRepository.findTop3(topThree);
//	}

}
