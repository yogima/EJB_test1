package com.searchSub.service;

import java.io.File;
import java.util.ArrayList;

public interface ISearchServ {
	public ArrayList<String> searchByImg(File uploadImage,String uploadImageContentType,String uploadImageFileName);
}
