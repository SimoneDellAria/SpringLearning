package it.mycompany.springfreemarker.dao;

import java.util.List;

import it.mycompany.springfreemarker.model.Product;

public interface ProductDAO {

	public void add(Product product);
	public void update(Product product);
	public void delete(Long id);
	public List<Product> getAll();
	public Product getProductById(Long id);
}
