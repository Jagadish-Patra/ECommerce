package com.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ITEMID;
	
	@Column(name="ITEMNAME")
	private String itemName;
	
	@Column(name="ITEMPRICE")
	private Integer itemPrice;

	public Integer getItemId() {
		return ITEMID;
	}

	public void setItemId(Integer itemId) {
		this.ITEMID = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
	
}
