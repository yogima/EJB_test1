package com.searchSub.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.searchSub.dao.IQuestionDAO;
import com.searchSub.po.IQuestion;
import com.searchSub.po.Question;

public class searchServ implements ISearchServ{
	
	private String realPath;//要保存文件的物理路径(绝对路径)
	private ArrayList<String> answers = new ArrayList<String>();;//答案数组
	private IQuestion ques;//有可能需要
	private IQuestionDAO quesDao;

	public ArrayList<String> searchByImg(File uploadImage,String uploadImageContentType,String uploadImageFileName) {
        //清除之前添加的答案
		answers.clear();
		
        uploadImageFileName=new Date().getTime()+ "_"+ uploadImageFileName.trim();
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/uploadImg/").trim();
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        realPath=ServletActionContext.getServletContext().getRealPath("/uploadImg/"+uploadImageFileName);
        
        //将得到的tmp文件保存
        FileOutputStream out;
        FileInputStream in;
		try {
			out = new FileOutputStream(realPath);
			in = new FileInputStream(uploadImage);

			byte[]buffer=new byte[1024];
			int len=0;
			while((len=in.read(buffer))!=-1)
			{
				out.write(buffer,0,len);			
			}
			
			out.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//识图
		//图片文件：此图片是需要被识别的图片  image服务器上的图片地址
        File file = new File(realPath);
        //recognizeText 为识别出来的文字
        String recognizeText = null;
		try {
			recognizeText = new OCRHelper().recognizeText(file).trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.print(recognizeText + "\t");
		
        
        //如果数据库中有则直接从数据库中读取，没有则使用爬虫并进存入数据库中
        String searchQuesHql = "From Question where question='"+recognizeText+"'";
        if(quesDao.findByHQL(searchQuesHql).size() > 0) {
        	List question = quesDao.findByHQL(searchQuesHql);
        	answers.add(((Question) question.get(0)).getAnswer());
        }else {
        	spider(recognizeText);
        }	
		if(answers != null)
			return answers;
		return null;
		
	}

	public void spider(String recognizeText) {
		//爬虫
		try {
	    
	        String question = "百度作业帮"+recognizeText;
			Document document = Jsoup.connect("https://www.baidu.com/s?ie=UTF-8&wd=" + question)
					// 模拟火狐浏览器
					.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
			for (int i = 1; i < 10; i++) {
				Element main = document.getElementById(String.valueOf(i));
				Elements url = main.select("h3").select("a");
				// 获取跳转后的页面url
				Elements trueurl = main.select("div[class=f13]").select("a");
				String URL = url.attr("abs:href");
				//是百度作业帮
				if (trueurl.text().startsWith("https://www.zybang.com")) {
					// 下载问题链接指向的页面
					Document document2 = Jsoup.connect(URL)
							.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
					// 获取当前页面的题目
					Element questionNow = document2.select("div[class=layout main-body]").select("div[class=main-con]")
							.select("div[class=questionWarp]").select("dl[class=card qb_wgt-question nobefore]")
							.select("dd").select("span").get(0);
					Element main1 = document2.getElementById("good-answer");
					// 获取当前页面题目的答案
					Element answer = main1.select("dd").select("span").get(0);
					// body > div.layout.main-body > div.main-con > div.questionWarp > dl > dd >
					// span

					System.out.println("\n" + "链接：" + URL + "\n" + "搜索问题：" + question + "\n" + "当前问题：" + questionNow.text()
							+ "\n" + "回答：" + answer.text());
					answers.add(answer.text());
					//System.out.print(answers);
					//将新的题目和答案存入数据库
					ques.setQuestion(recognizeText);
					ques.setAnswer(answer.text());
					quesDao.save(ques);
				} 
				/*
				 	else if (trueurl.text().startsWith("https://zhidao.baidu.com")) {
					Document document2 = Jsoup.connect(URL)
							.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
					// 获取当前页面的题目
					Elements questionNow= document2.getElementById("wgt-ask").select("h1").select("span");
					Element main1 = document2.getElementById("qb-content");
					// 获取当前页面题目的答案
					Elements answer = main1.select("div[class=wgt-best\r\n" + 
							"        wgt-recommend\r\n" + 
							"            ]").select("div[class=bd answer]").select("div[class=line content]").select("div[class=best-text mb-10]");
					// body > div.layout.main-body > div.main-con > div.questionWarp > dl > dd >
					// span

					System.out.println("\n" + "链接：" + URL + "\n" + "搜索问题：" + question + "\n" + "当前问题：" + questionNow.text()
							+ "\n" + "回答：" + answer.get(0).text().substring(4));//百度知道的答案前四个为“展开全部”.
					System.out.println(URL);
				} 
				*/
				else
					continue;
			}
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public IQuestionDAO getQuesDao() {
		return quesDao;
	}

	public void setQuesDao(IQuestionDAO quesDao) {
		this.quesDao = quesDao;
	}

	public IQuestion getQues() {
		return ques;
	}

	public void setQues(IQuestion ques) {
		this.ques = ques;
	}
	
	
}
