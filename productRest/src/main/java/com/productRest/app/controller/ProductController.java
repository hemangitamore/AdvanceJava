package com.productRest.app.controller;

import java.util.HashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.productRest.app.constants.ResponseKey;
import com.productRest.app.constants.ResponseMessage;
import com.productRest.app.model.Product;
import com.productRest.app.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MessageSource messageSource;
	@GetMapping("/greet")
	public ResponseEntity<?>greet(@RequestHeader(name="Accept-Language",required=false)Locale locale){
	String message=	messageSource.getMessage("greeting.message",null,locale);
	HashMap<String,String>responseBody=new HashMap<>();
	responseBody.put(ResponseKey.MESSAGE, message);
	return new ResponseEntity<>(responseBody,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<Object> findAll() {
	try {
		List<Product>productList= productService.findAll();
		if(productList.isEmpty()){
			HashMap<String,String>data=new HashMap<>();
			data.put(ResponseKey.MESSAGE, ResponseMessage.NO_PRODUCT_FOUND);
			return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
			
		}else {
			HashMap<String,Object>data=new HashMap<>();
			data.put(ResponseKey.COUNT, productService.countAll());
			data.put(ResponseKey.PRODUCTS, productList);
			return new ResponseEntity<>(productList,HttpStatus.OK);
			
			
		}
	}catch(Exception e) {
		HashMap<String,String>data=new HashMap<>();
		data.put(ResponseKey.MESSAGE, ResponseMessage.SOMETHING_WENT_WRONG);
		return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@PostMapping("/")
	public Product save(@RequestBody Product product) {
		Product savedproduct=productService.save(product);
		return savedproduct;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>findById(@PathVariable int id){
		HashMap<Object,Object>data=new HashMap<>();
		try {
			Optional<Product>productOptional=productService.findById(id);
			if(productOptional.isPresent()) {
				Product product=productOptional.get();
				return new ResponseEntity<>(product,HttpStatus.OK);
				
			}else {
				data.put(ResponseKey.MESSAGE, ResponseMessage.NO_PRODUCT_FOUND_BY_ID);
				return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
				
			}
		}catch(Exception e) {


			data.put(ResponseKey.MESSAGE, ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
			
		}

	@DeleteMapping("/{id}")
	public ResponseEntity<?>remove(@PathVariable int id) {
		HashMap<Object,Object>data=new HashMap<>();
		try {
			Optional<Product>productOptional=productService.findById(id);
			if(productOptional.isPresent()) {
				productService.remove(id);
				data.put(ResponseKey.MESSAGE, ResponseMessage.REMOVED);
				return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
				
			}else {
				data.put(ResponseKey.MESSAGE, ResponseMessage.NO_PRODUCT_FOUND_BY_ID);
				return new ResponseEntity<>(data,HttpStatus.NOT_FOUND);
				
			}
		}catch(Exception e) {


			data.put(ResponseKey.MESSAGE, ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
	}
	
	
	@GetMapping("/by-name/{name}")
	public ResponseEntity<?>findByName(@PathVariable String name){
		HashMap<Object,Object>data=new HashMap<>();
		try {
			List<Product>productList=productService.findByName(name);
			return new ResponseEntity<>(productList,HttpStatus.OK);
			
			
		}catch(Exception e) {

			data.put(ResponseKey.MESSAGE, ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
			


			
		}
		
	}
	
	@GetMapping("/descending")
	public ResponseEntity<?>findDesc(Product product){
		HashMap<Object,Object>data=new HashMap<>();
		try {
			List<Product>productList=productService.findDesc(product);
			return new ResponseEntity<>(productList,HttpStatus.OK);
			
			
		}catch(Exception e) {

			data.put(ResponseKey.MESSAGE, ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
			


			
		}
		
	}
	
//	@GetMapping("/Top")
//	public ResponseEntity<?>findTop3(Product product){
//		HashMap<Object,Object>data=new HashMap<>();
//		try {
//			List<Product>productList=productService.findTop3(product);
//			return new ResponseEntity<>(productList,HttpStatus.OK);
//			
//			
//		}catch(Exception e) {
//
//			data.put(ResponseKey.MESSAGE, ResponseMessage.SOMETHING_WENT_WRONG);
//			return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
//			
//
//
//			

		
}


