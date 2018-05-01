package com.pos.dto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product_item")
public class ProductItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String productItemName;
	private String notes;

/*	@OneToMany(mappedBy="productItem")
	private  Set<ItemModel> itemModelList;*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductItemName() {
		return productItemName;
	}
	public void setProductItemName(String productItemName) {
		this.productItemName = productItemName;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

/*	public Set<ItemModel> getItemModelList() {
		return itemModelList;
	}

	public void setItemModelList(Set<ItemModel> itemModelList) {
		this.itemModelList = itemModelList;
	}*/
}
