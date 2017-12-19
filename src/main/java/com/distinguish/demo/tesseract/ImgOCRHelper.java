package com.distinguish.demo.tesseract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jax
 * @Email: guoxingyou@xjiye.com
 * @Date: 2017/12/12/11:41
 * @Desc:
 **/
public class ImgOCRHelper {

    private final String LANG_OPTION = "-1";
    private final String EOL = System.getProperty("line.separator");
    private String tessPath = new File("tesseract").getAbsolutePath();

    public String recognizeText(File imageFile) throws Exception{

        /**
         * 设置输出文件的保存的文件目录
         */
        File outputFile = new File(imageFile.getParentFile(), "output");

        StringBuffer strB = new StringBuffer();
        List<String> cmd = new ArrayList<String>();
//        String os = System.getProperty("os.name");

//        if(os.toLowerCase().startsWith("win")){
//            cmd.add("tesseract");
//        }else {
//            cmd.add("tesseract");
//        }
        cmd.add("tesseract");
        cmd.add(imageFile.getName());
        cmd.add(outputFile.getName());
        cmd.add("digits");

        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(imageFile.getParentFile());
        pb.command(cmd);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        int w = process.waitFor();
        if (w == 0){// 0代表正常退出
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    new FileInputStream(outputFile.getAbsolutePath() + ".txt"),
                    "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                strB.append(str).append(EOL);
            }
            in.close();
        }else {
            String msg;
            switch (w) {
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
