package com.myntra.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.service.IProductServiceManagement;

@RestController
public class ProductController {
	@Autowired
	private IProductServiceManagement productService;
}
