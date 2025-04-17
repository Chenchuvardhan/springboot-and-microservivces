package com.myntra.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ProductDto {
	private Integer productId;
	private String productName;
	private String description;
	private String title;
	private String imageUrl;
	private Double unitPrice;
	private Boolean active;
	private Integer unitsStock;
	private LocalDate createdDate;
	private LocalDate updatedDate;
    private Integer categoryId;
}
