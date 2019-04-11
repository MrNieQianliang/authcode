package com.demo.bobo;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;

/**
 * @ProjectName: crackauthcode
 * @Package: com.demo.bobo
 * @ClassName: TessImg
 * @Author: alan
 * @Description: 使用TESS4J进行验证码的识别
 * @Date: 2019/3/4 14:42
 * @Version: 1.0
 */
public class TessImg {
    public static void main(String[] args) {
        String filePath = "/Users/alan/crackauthcode/img/1551681595900.jpg";
        String code = TessImg.File_Tess4j(filePath);
        System.out.println(code);
    }

    public static String File_Tess4j(String file_path){
        String result = null;
        System.out.println(file_path);
        File imageFile = new File(file_path);
        if(!imageFile.exists()){
            System.out.println("图片不存在");
        }
        ITesseract iTesseract  = new Tesseract();
        iTesseract.setDatapath("tessdata");
        iTesseract.setLanguage("chi_sim");
        try {
            result = iTesseract.doOCR(imageFile);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
