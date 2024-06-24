package com.productrest.app.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productrest.app.model.Product;
import com.productrest.app.model.Review;
import com.productrest.app.service.ProductService;

import constants.ResponseKey;
import constants.ResponseMessage;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MessageSource messageSource; 
	
	@GetMapping("/greet/{name}")
	public ResponseEntity<?> greet(@PathVariable("name") String name, @RequestHeader(name = "Accept-Language",required = false)Locale locale){
		String message = messageSource.getMessage("greeting.message", new Object[] {name}, locale);
		HashMap<String, String> responseBody = new HashMap<>();
		responseBody.put(ResponseKey.MESSAGE, message);
		return new ResponseEntity<>(responseBody, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/")
	public ResponseEntity<?> findAll(@RequestHeader(name ="Accept-Language", required = false) Locale locale) {
		try {
			List <Product> productList = productService.findAll(); 
			if(productList.isEmpty()) {
				// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				HashMap<String, String> data = new HashMap<>();
				data.put(ResponseKey.MESSAGE, messageSource.getMessage("error.noproductavailable",null,locale));
				return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
			}
			else {
				HashMap<String, Object> data = new HashMap<>();
				data.put(ResponseKey.COUNT, productService.countAll());
				data.put(ResponseKey.PRODUCTS, productList);
				
				
				return new ResponseEntity<>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			HashMap<String, String> data = new HashMap<>();
			data.put(ResponseKey.MESSAGE,messageSource.getMessage("error.exception",null,locale));
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody Product product) {
		try {
			Product savedProduct = productService.save(product);
			return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
		} catch (Exception e) {
			HashMap<String, String> data = new HashMap<>();
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		HashMap<Object, Object> data = new HashMap<>();
		try {
			Optional<Product> productOptional = productService.findById(id);
			if(productOptional.isPresent()) {
				Product product = productOptional.get();
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
			else {
				data.put(ResponseKey.MESSAGE, ResponseMessage.NO_PRODUCT_FOUND_BY_ID);
				return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
		
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable int id){
		HashMap<Object, Object> data = new HashMap<>();
		try {
			Optional<Product> productOptional = productService.findById(id);
			if(productOptional.isPresent()) {
				productService.remove(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				data.put(ResponseKey.MESSAGE, ResponseMessage.NO_PRODUCT_FOUND_BY_ID);
				return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
		
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	}
	
	@GetMapping("/by-name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		HashMap<Object, Object> data = new HashMap<>();
		try {
			List<Product> productsList = productService.findByName(name);
			return new ResponseEntity<>(productsList,HttpStatus.OK);
		} catch (Exception e) {
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}/reviews")
	public ResponseEntity<?> findAllReviewsByProduct(@PathVariable int id){
		HashMap<Object, Object> data = new HashMap<>();
		try {
			Optional<Product> productOptional = productService.findById(id);
			if(productOptional.isPresent()) {
				Product product = productOptional.get();
				List<Review> reviews = product.getReviews();
				return new ResponseEntity<>(reviews,HttpStatus.OK);
			}
			else {
				data.put(ResponseKey.MESSAGE,ResponseMessage.NO_PRODUCT_FOUND);
				return new ResponseEntity<>(data,HttpStatus.OK);
			}
			
		} catch (Exception e) {
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
	

