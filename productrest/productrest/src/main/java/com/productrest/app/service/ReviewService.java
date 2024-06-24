package com.productrest.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productrest.app.model.Review;
import com.productrest.app.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review save(Review review) {
		return reviewRepository.save(review);
	}
}
