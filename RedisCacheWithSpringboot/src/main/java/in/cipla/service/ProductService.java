package in.cipla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cipla.entity.Product;
import in.cipla.repository.ProductRepository;
@Service
public class ProductService implements IProductService {

	@Autowired 
	private  ProductRepository productRepo;
	@Override
	public String saveProduct(Product p) {
		// TODO Auto-generated method stub
		Product save = productRepo.save(p);
		return "product saved ::"+save;
	}

	@Override
	public Iterable<Product> getProducts() {
		// TODO Auto-generated method stub
		Iterable<Product> all = productRepo.findAll();
		return all;
	}

}
