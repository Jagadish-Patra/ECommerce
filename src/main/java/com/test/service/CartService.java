package com.test.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.Cart;
import com.test.domain.Item;
import com.test.repo.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository repo;
	
	public List<Item> getAllItem(){
		return repo.getAllItem();
	}
	
	public Cart storeItemInCart(Cart cart){
		Integer gen=null;
		if(cart.getCartId()==null) {
			gen=(int) ((Math.random()*((1000-1)+1))+1);
			repo.saveCartId(gen);			
			repo.storeItemInCart(cart.getItems(), gen);
			return getCartItem(gen);
		}else {
			repo.storeItemInCart(cart.getItems(), cart.getCartId());
			return getCartItem(cart.getCartId());
		}
	}
	
	public Cart getCartItem(int cartId) {
		Cart dbCart = repo.getCart(cartId);
		if (dbCart == null) {
			throw new RuntimeException("cart doesnot exist !!");
		}
		dbCart.setItems(repo.getCartItem(cartId));
		return dbCart;
	}
}
