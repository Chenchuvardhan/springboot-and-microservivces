package in.cipla.service;


import in.cipla.entity.Product;

public interface IProductService {
public abstract String saveProduct(Product p);
public abstract Iterable<Product> getProducts();
}
