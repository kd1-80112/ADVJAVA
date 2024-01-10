package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
public class Products extends BaseEntity{
@Column(name="prod_name")
private String name;
@Column(name="prod_desc")
private String description;
@Column(name="prod_price")
private Double price; 
@Column(name="prod_stock")
private int stock;
@Column(name="prod_exp")
private LocalDate expiryDate;
@ManyToOne
@JoinColumn(name = "catg_id" ,nullable = false )
private Catogary catogary;

public Products(String name, String description,  Double price, int stock, LocalDate expiryDate) {
	
	this.name = name;
	this.description = description;
	this.price = price;
	this.stock = stock;
	this.expiryDate = expiryDate;
}


@Override
public String toString() {
	return "Products [prodid="+ getId()+"name=" + name + ", description=" + description + ", price="
			+ price + ", stock=" + stock + ", expiryDate=" + expiryDate + "]";
}


}
