package com.util;

import java.io.*;

public class FilesUtil {
    /**
     * 读取txt文件
     *
     * @param path 文件的绝对路径
     * @return 返回String类型的文本
     */
    public static String readTxt(String path) {
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator()).append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 打印文本
     *
     * @param path    打印文本的路径
     * @param content 文本的内容
     */
    public static void writeTxt(String path, String content) {
        File file = new File(path);
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(file));//构造一个BufferedWriter来写文件
            wr.write(content);
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
