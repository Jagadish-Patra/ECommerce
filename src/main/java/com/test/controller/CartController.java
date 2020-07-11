package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.Cart;
import com.test.domain.Item;
import com.test.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService service;
	
	@GetMapping("/items")
	public List<Item> getAllItem(){
		return service.getAllItem();
	}
	
	@GetMapping("/cart/{cartId}")
	public Cart getCart(@PathVariable("cartId") int cartId){
		return service.getCartItem(cartId);
	}
	
	@PostMapping(value="/add")
	public Cart addToCart(@RequestBody Cart cart){
		 return service.storeItemInCart(cart);
	}
}
