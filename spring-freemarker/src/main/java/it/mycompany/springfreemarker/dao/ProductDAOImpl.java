package it.mycompany.springfreemarker.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import it.mycompany.springfreemarker.model.Product;

public class ProductDAOImpl implements ProductDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public ProductDAOImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void add(Product product) {
		String query = "INSERT INTO product(name, price) VALUES(?, ?)";
		jdbcTemplate.update(query, product.getName(), product.getPrice());
	}

	@Override
	public void update(Product product) {
		String query = "UPDATE product SET name = ?, price = ? WHERE id = ?";
		jdbcTemplate.update(query, product.getName(), product.getPrice(), product.getId());
	}

	@Override
	public void delete(int id) {
		String query = "DELETE FROM product WHERE id = ?";
		jdbcTemplate.update(query, id);
		
	}

	@Override
	public List<Product> getAll() {
		String query = "SELECT id, name, price FROM product";
		ArrayList<Product> products = (ArrayList<Product>) jdbcTemplate.query(query, productList);
		return products;
	}
	
	private RowMapper<Product> productList = (result, row) ->{
		Product product = new Product();
		product.setId(result.getLong("id"));
		product.setName(result.getString("name"));
		product.setPrice(result.getInt("price"));
		return product;
	};

	@Override
	public Product getProductById(int id) {
		String query = "SELECT id, name, price FROM product WHERE id = ?";
		Product product = jdbcTemplate.queryForObject(query, productList, id);
		return product;
	}
	
}
