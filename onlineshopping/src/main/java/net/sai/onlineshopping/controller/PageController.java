package net.sai.onlineshopping.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sai.onlineshopping.Exception.ProductNotFound;
import net.sai.shoppingbackend.dao.CategoryDao;
import net.sai.shoppingbackend.dao.ProductDao;
import net.sai.shoppingbackend.dto.Category;
import net.sai.shoppingbackend.dto.Product;

@Controller
public class PageController {
	final static Logger logger=Logger.getLogger(PageController.class);
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryDao.list());
		return mv;
	}
	@RequestMapping(value={"/about"})
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	@RequestMapping(value={"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	/**
	 * Methods to load all products based on category
	 * */
	@RequestMapping(value={"/show/all/products"})
	public ModelAndView showAll()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDao.list());
		return mv;
	}
	@RequestMapping(value={"/show/category/{id}/products"})
	public ModelAndView showCategory(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("page");
		//category to fetch single category
		Category category=null;
		
		category=categoryDao.get(id);
		
		mv.addObject("title",category.getName());
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("categories", categoryDao.list());
		//passing single category
		mv.addObject("category", category);
		return mv;
	}
	/*
	 * Viewing a single product*/
	@RequestMapping(value={"/show/{id}/product"})
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFound{
	ModelAndView mv=new ModelAndView("page");
	Product product=productDao.get(id);
	if(product==null) throw new ProductNotFound();
	product.setViews(product.getViews() +1);
	productDao.update(product);
	mv.addObject("title", product.getName());
	mv.addObject("product",product);
	mv.addObject("userClickShowProduct",true);
	return mv;
	}
	
}
