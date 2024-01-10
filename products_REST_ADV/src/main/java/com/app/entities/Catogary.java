package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="catogary")
@Getter
@Setter
@NoArgsConstructor

public class Catogary extends BaseEntity{

@Column(name="catg_name")
private String name;
@Column(name="cat_desc")
private String description;


public Catogary(String name, String description) {
	
	this.name = name;
	this.description = description;
}


}
