package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddProductsDTO {
	
	
//	String name, String description,  Double price, int stock, LocalDate expiryDate
	@NotNull
	private Long categoryid;
	@NotBlank
	private String name;
	private String description;
	@Max(500)
	private String price;
	private int stock;
	@Future
	private  LocalDate expiryDate;
}
