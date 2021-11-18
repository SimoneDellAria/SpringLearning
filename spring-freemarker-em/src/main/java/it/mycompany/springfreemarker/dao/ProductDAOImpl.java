package it.mycompany.springfreemarker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import it.mycompany.springfreemarker.model.Product;

public class ProductDAOImpl implements ProductDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public ProductDAOImpl() {
	}

	@Override
	@Transactional
	public void add(Product product) {
		this.entityManager.persist(product);
	}

	@Override
	@Transactional
	public void update(Product product) {
		this.entityManager.merge(product);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Product p = getProductById(id);
		this.entityManager.remove(p);
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = this.entityManager.createQuery("from Product", Product.class).getResultList();
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		return this.entityManager.find(Product.class, id);
	}
	
}
