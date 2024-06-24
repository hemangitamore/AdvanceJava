package com.productrest.app.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productrest.app.model.Product;
import com.productrest.app.model.Review;
import com.productrest.app.service.ProductService;
import com.productrest.app.service.ReviewService;

import constants.ResponseKey;
import constants.ResponseMessage;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ProductService productService;
	

	@PostMapping("/product/{id}")
	public ResponseEntity<?> save(@PathVariable int id, @RequestBody Review review) {
		try {
			Review savedReview = null;
			Optional<Product> productOptional = productService.findById(id);
			if(productOptional.isPresent()) {
				Product p = productOptional.get();
				review.setProduct(p);
				p.getReviews().add(review);
				savedReview = reviewService.save(review);
			}
			return new ResponseEntity<>(savedReview, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			HashMap<String, String> data = new HashMap<>();
			data.put(ResponseKey.MESSAGE,ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
