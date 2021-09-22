package com.util;

import com.hankcs.hanlp.HanLP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CheckPaper {

    /**
     * 获得两个句子的相似度
     * @param sentence1 文本1
     * @param sentence2 文本2
     * @return 保留两位小数的相似度结果
     */
    public static double getSimilarity(String sentence1, String sentence2) {
        //将传入的两个文本切割成词语组成的list
        List<String> sent1Words = getSplitWords(sentence1);
        List<String> sent2Words = getSplitWords(sentence2);
        //合并两个词语集合
        List<String> allWords = mergeList(sent1Words, sent2Words);

        //获取两个句子在allWords中每个词相同的个数
        int[] statistic1 = statistic(allWords, sent1Words);
        int[] statistic2 = statistic(allWords, sent2Words);

        //计算相似度的算法
        double dividend = 0;
        double divisor1 = 0;
        double divisor2 = 0;
        for (int i = 0; i < statistic1.length; i++) {
            dividend += statistic1[i] * statistic2[i];
            divisor1 += Math.pow(statistic1[i], 2);
            divisor2 += Math.pow(statistic2[i], 2);
        }

        return dividend / (Math.sqrt(divisor1) * Math.sqrt(divisor2));
    }

    /**
     *
     * @param allWords 两个文本合并的词语集合
     * @param sentWords 一个文本的词语集合
     * @return sentWords中的每个词在allwords中有多少个相同的元素
     */
    private static int[] statistic(List<String> allWords, List<String> sentWords) {
        int[] result = new int[allWords.size()];
        for (int i = 0; i < allWords.size(); i++) {
            result[i] = Collections.frequency(sentWords, allWords.get(i));
        }
        return result;
    }

    /**
     * 将两个集合合并成一个集合
     * @param list1 集合1
     * @param list2 集合2
     * @return 合并后的集合
     */
    private static List<String> mergeList(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        //合并集合
        result.addAll(list1);
        result.addAll(list2);
        return result.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 例用HanLP 将文本分割成词语进行比较
     * @param sentence 被分割的文本
     * @return 分割后的词语组成的list
     */
    private static List<String> getSplitWords(String sentence) {
        return HanLP.segment(sentence).stream().map(a -> a.word).filter(s -> !"`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？ ".contains(s)).collect(Collectors.toList());
    }


}
