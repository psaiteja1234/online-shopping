package net.sai.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sai.shoppingbackend.dao.CategoryDao;
import net.sai.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("net.sai.shoppingbackend");
		context.refresh();
		categoryDao=(CategoryDao) context.getBean("categoryDao");
		
	}
	
	/*@Test
	public void testAddCategory()
	{
		Category category=new Category();
		category.setName("Tele");
		category.setDescription("new TV");
		category.setImageUrl("CAT_1.png");
		assertEquals("Successfully added",true,categoryDao.add(category));
	}*/
	
	/*@Test
	public void testGetCategory()
	{
		category=categoryDao.get(1) ;
		assertEquals("Succesfully fetched","Tele",category.getName());
		
	}*/
/*	@Test
	public void testUpdateCategory()
	{
		category=categoryDao.get(1) ;
		category.setName("TV");
		category.setActive(true);
		assertEquals("Succesfully fetched",true,categoryDao.update(category));
		
	}*/
	
	/*@Test
	public void testDeleteCategory()
	{
		category=categoryDao.get(1) ;
		//category.setName("TV");
		assertEquals("Succesfully deleted",true,categoryDao.delete(category));
		
	}*/
/*	@Test
	public void testListCategory()
	{
		category=categoryDao.get(1) ;
		category.setName("TV");
		category.setActive(true);
		assertEquals("Succesfully fetched list",1,categoryDao.list().size());
		
	}*/
	
	@Test
	public void testCRUDCategory()
	{
		Category category=new Category();
		category.setName("Mobile");
		category.setDescription("new Mobile");
		category.setImageUrl("CAT_2.png");
		assertEquals("Successfully added",true,categoryDao.add(category));
		
		category=categoryDao.get(1) ;
		category.setName("Television");
		assertEquals("Succesfully fetched",true,categoryDao.update(category));
		
		category=categoryDao.get(1) ;
		category.setName("TV");
		category.setActive(true);
		assertEquals("Succesfully fetched list",2,categoryDao.list().size());
	}
	
}
