package com.productrest.app.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String content;
	private String reviewGivenBy;
	
	@JsonIgnore
	@ManyToOne
	private Product product;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReviewGivenBy() {
		return reviewGivenBy;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + ", reviewGivenBy=" + reviewGivenBy + ", product=" + product
				+ "]";
	}
	public void setReviewGivenBy(String reviewGivenBy) {
		this.reviewGivenBy = reviewGivenBy;
	}
	
}
