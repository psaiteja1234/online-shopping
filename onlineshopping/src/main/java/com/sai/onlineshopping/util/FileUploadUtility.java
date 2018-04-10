package com.sai.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH="F:\\Saiteja Parepalli\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images";
	private static  String REAL_PATH="";
	private static final Logger logger=Logger.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// TODO Auto-generated method stub
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images");
		logger.info(REAL_PATH);
		//make sure directory present or not
		if(!new File(ABS_PATH).exists())
		{
			new File(ABS_PATH).mkdirs();
		}
		if(!new File(REAL_PATH).exists())
		{
			new File(REAL_PATH).mkdirs();
		}
		try{
			file.transferTo(new File(REAL_PATH + code + ".png"));
			file.transferTo(new File(ABS_PATH + code + ".png"));
			
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
}
