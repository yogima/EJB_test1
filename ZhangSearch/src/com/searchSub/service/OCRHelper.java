package com.searchSub.service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OCRHelper 
{

    private final String LANG_OPTION = "-l";
    private final String EOL = System.getProperty("line.separator");

    
    private String tessPath = "D:\\Tesseract-OCR";
    //private String tessPath = new File("tesseract").getAbsolutePath();

    public String recognizeText(File imageFile) throws Exception 
    {
        
        File outputFile = new File(imageFile.getParentFile(), "output");

        StringBuffer strB = new StringBuffer();
        List<String> cmd = new ArrayList<String>();

        cmd.add(tessPath + "\\tesseract");

        cmd.add("");
        cmd.add(outputFile.getName());
        cmd.add(LANG_OPTION);
        cmd.add("chi_sim");
        cmd.add("math");
        cmd.add("eng");
        
        //创建操作系统进程
        ProcessBuilder pb = new ProcessBuilder();
        /**
         *Sets this process builder's working directory.
         */
        
        //此方法返回此进程生成器,directory -- 新的工作目录
        pb.directory(imageFile.getParentFile());
        System.out.println("helper类中的路径："+imageFile.getParentFile());
        cmd.set(1, imageFile.getName());
        //设置此进程生成器的操作系统程序和参数
        pb.command(cmd);
        pb.redirectErrorStream(true);
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + startTime);
        Process process = pb.start();
        
//      System.out.println(cmd.toString());
        
        //waitfor错误代码1：操作不允许 有空格/进程执行所需的环境不正确
        int w = process.waitFor();
        if (w == 0)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile.getAbsolutePath() + ".txt"),"UTF-8"));
            String str;

            while ((str = in.readLine()) != null) 
            {
                strB.append(str).append(EOL);
            }
            in.close();

            long endTime = System.currentTimeMillis();
            System.out.println("结束时间：" + endTime);
            System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        } 
        else 
        {
            String msg;
            switch (w) 
            {
                case 1:
                    msg = "Errors accessing files. There may be spaces in your image's filename.";
                    break;
                case 29:
                    msg = "Cannot recognize the image or its selected region.";
                    break;
                case 31:
                    msg = "Unsupported image format.";
                    break;
                default:
                    msg = "Errors occurred.";
            }
            throw new RuntimeException(msg);
        }
        new File(outputFile.getAbsolutePath() + ".txt").delete();
        return strB.toString().replaceAll("\\s*", "");
    }
}
