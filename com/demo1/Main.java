package com.demo1;

import com.DealException.InsertException;
import com.util.CheckPaper;
import com.util.FilesUtil;
import com.util.JudgeInsert;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        try {
            if (JudgeInsert.judgeInsertAmount(args)) {
                throw new InsertException("输入参数数量有误");
            }
            String content = FilesUtil.readTxt(args[0]);//0 元素代表原论文
            String compare = FilesUtil.readTxt(args[1]);//1 元素代表抄袭版论文文件
            double ans = CheckPaper.getSimilarity(content, compare) * 100;//比较方法
            DecimalFormat df = new DecimalFormat("0.00");//保留两位数输出
            FilesUtil.writeTxt(args[2], df.format(ans) + "%");
        }catch (InsertException e) {
            e.printStackTrace();
        }
    }

}
