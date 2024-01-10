package com.app.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddProductDTO2 {
//	String name, String description,  Double price, int stock, LocalDate expiryDate
	@JsonProperty(value="prod_id",access = Access.READ_ONLY)
	private int productid;
	private String name;
	private String description;
    private Double price;
    private int Stock;
    private LocalDate expiryDate;
}
