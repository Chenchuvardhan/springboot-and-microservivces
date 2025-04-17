package com.myntra.dto;

import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {
	private Integer categoryId;
	private Integer categoryName;
	private List<ProductDto> productDtos;
}
