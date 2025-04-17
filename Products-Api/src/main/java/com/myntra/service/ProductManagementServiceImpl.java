package com.myntra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.myntra.dto.CategoryDto;
import com.myntra.dto.ProductDto;
import com.myntra.entity.Category;
import com.myntra.entity.Products;
import com.myntra.repository.CategoryRepository;
import com.myntra.repository.ProductRepository;

public class ProductManagementServiceImpl implements IProductServiceManagement {
    @Autowired
	private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepo;
	@Override
	public List<ProductDto> getProducts() {
		// TODO Auto-generated method stub
		List<Products> products = productRepo.findAll();
		List<ProductDto> productDtosList=new ArrayList<>();
		products.stream().forEach(product->{
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product,productDto);
			productDto.setCategoryId(product.getProductId());
			productDtosList.add(productDto);
		});
		return productDtosList;
	}
	@Override
	public CategoryDto getProducts(int categoryid) {
		// TODO Auto-generated method stub
		Optional<Category> categoryOpt = categoryRepo.findById(categoryid);
	
		if(categoryOpt.isPresent()) {
			Category category=categoryOpt.get();
			CategoryDto categoryDto = new CategoryDto();
			BeanUtils.copyProperties(category, categoryDto);
			List<ProductDto> productDtosList=new ArrayList<>();
			List<Products> products = category.getProducts();
			products.stream().forEach(product->{
			ProductDto productDto = new	ProductDto();
			BeanUtils.copyProperties(product, productDto);
			productDto.setCategoryId(category.getCategoryId());
			productDtosList.add(productDto);
			});
			categoryDto.setProductDtos(productDtosList);
			return categoryDto;
		}
		return null;
	}
	@Override
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		List<Category> categoryList = categoryRepo.findAll();
		List<CategoryDto> categoryDtoList=new ArrayList<>();
		categoryList.stream().forEach(category->{
			CategoryDto categoryDto = new CategoryDto();
			BeanUtils.copyProperties(category, categoryDto);
			List<ProductDto> productDtosList=new ArrayList<>();
			List<Products> products = category.getProducts();
			products.stream().forEach(product->{
			ProductDto productDto = new	ProductDto();
			BeanUtils.copyProperties(product, productDto);
			productDto.setCategoryId(category.getCategoryId());
			productDtosList.add(productDto);
			});
			categoryDto.setProductDtos(productDtosList);
			categoryDtoList.add(categoryDto);
		});
		return null;
	}
	@Override
	public List<ProductDto> saveProducts(List<ProductDto> productDtoList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductDto deleteProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductDto saveProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CategoryDto modifyPriceOfCategories(int categoryId, int percentage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}