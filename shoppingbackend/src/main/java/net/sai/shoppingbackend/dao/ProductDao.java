package net.sai.shoppingbackend.dao;

import java.util.List;

import net.sai.shoppingbackend.dto.Product;

public interface ProductDao {

	List<Product> list();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	Product get(int productId);

	List<Product> listActiveProducts();

	List<Product> listActiveProductsByCategory(int categoryId);

	List<Product> getLatestActiveProducts(int count);

}
