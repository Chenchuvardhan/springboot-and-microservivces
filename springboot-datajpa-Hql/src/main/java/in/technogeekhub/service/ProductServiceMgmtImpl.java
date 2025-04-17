package in.technogeekhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.technogeekhub.entity.Product;
import in.technogeekhub.repository.ProductRepository;

@Service
public class ProductServiceMgmtImpl implements IProductServiceMngm {

	@Autowired
	private ProductRepository prodtRepo;
	@Override
	public String registerdProduct() {
		
		Product p1= new Product();
		p1.setProductId(1000);
		p1.setProductName("T-shirt");
		p1.setModificationCount(4);
		p1.setPrice(3500d);
		Integer prodId = prodtRepo.save(p1).getProductId();
		
		return "SuccessFully registerd with this product id ::"+prodId;
	}

}
