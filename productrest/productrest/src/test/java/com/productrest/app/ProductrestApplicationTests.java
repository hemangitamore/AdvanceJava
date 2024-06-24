package com.productrest.app;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productrest.app.model.Product;
import com.productrest.app.service.ProductService;

//@SpringBootTest
@WebMvcTest
class ProductrestApplicationTests {

	@SpringBootTest
	@WebMvcTest
	class TestingdemoApplicationTests {
		@Autowired
		private MockMvc mockMvc; // to mock request, response and data
		
		@Autowired
		private ObjectMapper objectMapper; // for json <-> java object
		
		@MockBean
		private ProductService productService; // to make this productService point towards the mock data
	
		@Test
		private void getProductsListTest() {
			List<Product> list = new ArrayList<>();
			Product p1 = new Product();
			p1.setId(101);
			p1.setName("Keyboard");
			p1.setPrice(100);
			p1.setQuantity(10);
			
			Product p2 = new Product();
			p2.setId(100);
			p2.setName("usb drive");
			p2.setPrice(500);
			p2.setQuantity(15);
			
			list.add(p1);
			list.add(p2);
			
			when(productService.findAll()).thenReturn(list);
			try {
				ResultActions response = mockMvc.perform(get("/products"));
				response.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.count", is(list.size())));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
