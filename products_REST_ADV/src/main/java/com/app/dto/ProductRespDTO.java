package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductRespDTO {

	private Long id;
	private String name;
	private String description;
	private String price;
	private int stock;
	private LocalDate expiryDate;

}
