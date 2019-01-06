package com.searchSub.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opensymphony.xwork2.ActionSupport;
import com.searchSub.service.OCRHelper;

public class UploadAction extends ActionSupport implements RequestAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File wj;
	private String wjContentType;//文件类型
	private String wjFileName;//文件名
	private ArrayList<String> answers;
	private String Ques;
 	public File getWj() 
 	{
		return wj;
	}
	public void setWj(File wj) 
	{
		this.wj = wj;
	}
	public String getWjContentType() 
	{
		return wjContentType;
	}
	public void setWjContentType(String wjContentType) 
	{
		this.wjContentType = wjContentType;
	}
	public String getWjFileName() 
	{
		return wjFileName;
	}
	public void setWjFileName(String wjFileName) 
	{
		this.wjFileName = wjFileName;
	}
	@Override
	public String execute() throws Exception 
	{
		// TODO Auto-generated method stub
		//修改文件名
		answers=new ArrayList<String>();
		ServletContext servletContext=ServletActionContext.getServletContext();
		String path=servletContext.getRealPath("/img/"+wjFileName);//文件最终要上传到的路径
		FileOutputStream out=new FileOutputStream(path);
		FileInputStream in=new FileInputStream(wj);
		byte[]buffer=new byte[1024];
		int len=0;
		while((len=in.read(buffer))!=-1)
		{
			out.write(buffer,0,len);			
		}
		out.close();
		in.close();	
		//String image="/img/"+wjFileName;		
		//识图
		try 
		{
	        //图片文件：此图片是需要被识别的图片 
	        File file = new File(path);
	        String recognizeText = new OCRHelper().recognizeText(file).trim();
	        Ques=recognizeText;
	        System.out.print(recognizeText + "\t");
	    //爬虫	        
	        String question = "百度作业帮"+recognizeText;
			Document document = Jsoup.connect("https://www.baidu.com/s?ie=UTF-8&wd="+question)
					// 模拟火狐浏览器
					.userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();	
			for (int i = 1; i < 10; i++)
			{	
				Element main= document.getElementById(String.valueOf(i));
				Elements url =null;
				try{
					url = main.select("h3").select("a");
				}
				catch(Exception e) 
				{
					e.printStackTrace();
					break;
				}
				// 获取跳转后的页面url
				Elements trueurl = main.select("div[class=f13]").select("a");
				String URL = url.attr("abs:href");
				//是百度作业帮
				if (trueurl.text().startsWith("https://www.zybang.com")) 
				{
					// 下载问题链接指向的页面
					Document document2 = Jsoup.connect(URL).userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)").get();
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
						System.out.print(answers);
						
				} 
				/*else if (trueurl.text().startsWith("https://zhidao.baidu.com")) 
				{
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
							+ "\n" + "回答：" + answer.get(0).text().substring(4));
					//百度知道的答案前四个为“展开全部”.
					System.out.println(URL);
				} */
				else
					continue;
			}
	        return "success";
	    } 
		catch (IOException e)
		{
	        e.printStackTrace();
	    } 
		catch (Exception e)
		{
	        e.printStackTrace();
	
	    }
		return "success";
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {}	
	public ArrayList<String> getAnswers() 
	{
		return answers;
	}
	public void setAnswers(ArrayList<String> answers) 
	{
		this.answers = answers;
	}
	public String getQues() 
	{
		return Ques;
	}
	public void setQues(String ques) 
	{
		Ques = ques;
	}
}