package net.sai.onlineshopping.Exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultException {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","page not designed");
		mv.addObject("errorDescription","page you are looking not available");
		mv.addObject("title","404 Error page");
		return mv;
	}
	@ExceptionHandler(ProductNotFound.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","page not available");
		mv.addObject("errorDescription","product you are looking is not available");
		mv.addObject("title","Product Unavailable");
		return mv;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","contact Administarator");
		/*
		 * Only for debugging*/
		
		StringWriter s=new StringWriter();
		PrintWriter p=new PrintWriter(s);
		ex.printStackTrace(p);
		
		mv.addObject("errorDescription",s.toString());
		mv.addObject("title","400  Error page");
		return mv;
	}
}
