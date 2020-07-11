package com.test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.domain.Item;

public interface CartRepoInterf extends JpaRepository<Item, Integer>{

	//public void storeInCart(List<Item> items,int cartId);
}
