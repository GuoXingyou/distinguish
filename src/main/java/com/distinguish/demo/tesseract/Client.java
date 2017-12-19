package com.distinguish.demo.tesseract;

import java.io.File;

/**
 * @Author: Jax
 * @Email: guoxingyou@xjiye.com
 * @Date: 2017/12/12/12:25
 * @Desc:
 **/
public class Client {


    public static void main(String[] args) throws Exception {
        TesseractOCR("F:\\ImgOCRHelper-OCR\\test4.png");
    }

    private static void TesseractOCR(String filePath) throws Exception {
        File file = new File(filePath);
        String recognizeText = new ImgOCRHelper().recognizeText(file);
        System.out.println(recognizeText);
    }
}
