package net.sai.shoppingbackend.dao;

import java.util.List;

import net.sai.shoppingbackend.dto.Category;

public interface CategoryDao {
	
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	List<Category> list();

	  Category get(int id);

}
