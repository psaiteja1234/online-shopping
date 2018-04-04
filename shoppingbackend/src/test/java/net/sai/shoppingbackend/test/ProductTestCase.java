package net.sai.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sai.shoppingbackend.dao.CategoryDao;
import net.sai.shoppingbackend.dao.ProductDao;
import net.sai.shoppingbackend.dto.Category;
import net.sai.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;

	private static ProductDao productDao;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sai.shoppingbackend");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");

	}

/*	@Test
	public void testCRUDCategory() {
		Product product = new Product();
		product.setName("Oppo F3");
		product.setBrand("Oppo");
		product.setActive(true);
		product.setDescription("This is Oppo phone");
		product.setCategoryId(3);
		product.setSupplierId(3);
		product.setUnitPrice(15000);
		assertEquals("Successfully added", true, productDao.add(product));
		product = productDao.get(2);
		product.setName("Galaxy S7");
		assertEquals("Succesfully fetched", true, productDao.update(product));

		product = productDao.get(1);
		product.setActive(true);
		assertEquals("Succesfully fetched list", 6, productDao.list().size());

	}*/
	@Test
	public void testListActiveProducts()
	{
		assertEquals("Succesfully fetched list", 7, productDao.listActiveProducts().size());
	}
}
