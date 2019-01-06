package com.searchSub.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.searchSub.service.ISearchServ;

public class searchAction implements RequestAware{
	
	private File uploadImage; //得到上传的文件
	private String uploadImageContentType; //得到文件的类型
	private String uploadImageFileName; //得到文件的名称
	
	private ISearchServ serv = null;
	private ArrayList<String> answers;
	private Map request;
	
	public ISearchServ getServ() {
		return serv;
	}

	public void setServ(ISearchServ serv) {
		this.serv = serv;
	}

	public String Img() {
		
		if(serv.searchByImg(uploadImage,uploadImageContentType,uploadImageFileName) != null) {
			
			System.out.println("fileName:"+uploadImageFileName);
			
			answers = serv.searchByImg(uploadImage,uploadImageContentType,uploadImageFileName);
			request.put("answers", answers);
			return "success";
		}
		return "fail";
	}
	
	public String search() {
		return "fail";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}
	
	
}
