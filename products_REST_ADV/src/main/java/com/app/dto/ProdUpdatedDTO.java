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
public class ProdUpdatedDTO {
	@JsonProperty(value="prod_id",access = Access.READ_ONLY)
	private Long id;
	private Double price;
}
