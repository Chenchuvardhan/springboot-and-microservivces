package in.cipla.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cipla.entity.Product;
import in.cipla.service.IProductService;

@RestController
public class ProductController {
	@Autowired
	private IProductService productService;

	@PostMapping(value = "/product")
	public String saveProduct(@RequestBody Product p) {
		return productService.saveProduct(p);
	}

	@GetMapping(value = "/products")
	public Iterable<Product> getProducts() {
		return productService.getProducts();
	}
}
