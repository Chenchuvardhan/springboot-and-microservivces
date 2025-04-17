package com.myntra.service;

import java.util.List;

import com.myntra.dto.CategoryDto;
import com.myntra.dto.ProductDto;

public interface IProductServiceManagement {
public List<ProductDto> getProducts();
public CategoryDto getProducts(int  categoryid); 
public List<CategoryDto> getCategories();
public List<ProductDto> saveProducts(List<ProductDto> productDtoList);
public ProductDto deleteProduct(int id);
public ProductDto saveProduct(ProductDto productDto);
public CategoryDto modifyPriceOfCategories(int categoryId,int percentage);
}
