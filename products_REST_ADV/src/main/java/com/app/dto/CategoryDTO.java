package com.app.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;

@Getter
@Setter
@ToString
public class CategoryDTO {
	@JsonProperty(value="catg_id",access = Access.READ_ONLY)
	private Long id;
	private String name;
	private String description;
}
