package com.test.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.Cart;
import com.test.domain.Item;

@Repository
public class CartRepository {

	@Autowired
	EntityManager entity;

	public List<Item> getAllItem() {
		Session session = entity.unwrap(Session.class);
		Query<Item> createQuery = session.createQuery("from Item", Item.class);
		return createQuery.getResultList();
	}
	
	@Transactional
	public void storeItemInCart(List<Item> items,int cartId){
		
		for(Item item:items) {
		String insertSQL = "INSERT INTO CART_ITEM (CARTID, ITEMID) VALUES ("+ cartId+","+item+")";
        entity.createNativeQuery(insertSQL).executeUpdate();
	}
	}
	
	@Transactional
	public void saveCartId(int cartId){
		
		String insertSQL = "INSERT INTO CART(CARTID, LASTMODIFIED) VALUES(?,SYSTIMESTAMP)";
        entity.createNativeQuery(insertSQL)
        .setParameter(1, cartId)
        .executeUpdate();
	}
	
	public Cart getCart(int cartId){
		
		String qry = "select * from cart where cartid="+cartId;
        Object singleResult = entity.createNativeQuery(qry).getSingleResult();
        return (Cart)singleResult;
        
	}


	public List<Item> getCartItem(int cartId) {
		
		String insertSQL = "select * from cart_item where cartId="+cartId;
		List<Item> items=entity.createNativeQuery(insertSQL).getResultList();
		return items;
	}
	

}
