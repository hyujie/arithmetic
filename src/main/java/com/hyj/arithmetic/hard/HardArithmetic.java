package com.hyj.arithmetic.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ Authord  yujie huang  email: 190158792@qq.com
 * @ Description
 * @ Date Create by in 14:41 2019/1/11
 */
public class HardArithmetic {

    /**
     * 你有一个字符串，s，和一个单词列表，单词，都是相同的长度。
     * 查找s中的所有子字符串的起始索引，这些子字符串是单词中每个单词的连接，只连接一次，没有任何中间字符。
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>(10);
        Map<Integer,String> map = new HashMap<Integer, String>(10);
        if(words.length == 0){
            return result;
        }
        int length = words[0].length()*(words.length);
        if(s.length() < length){
            return result;
        }
        boolean bool = true;
        int startIndex = 0;
        while(bool){
            if(startIndex+length > s.length()){
                break;
            }else if(startIndex+length  == s.length()){
                bool = false;
            }
            String word = s.substring(startIndex,startIndex+length);
            map.put(startIndex,word);
            System.out.println(word);
            startIndex++;
        }
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            String temp = entry.getValue();
            for(String s2:words){
                bool  = true;
                int num = 0;
                //String[] strings = new String[]{"ab","ba","ba"};
                //String s = "ababaab";
                while (bool){
                    num = temp.indexOf(s2,num);
                    if(num == -1){
                        break;
                    } else if(num%s2.length() == 0 ){
                        System.out.println(num+"====");
                        System.out.println(num+s2.length()+"=========");
                        temp = temp.substring(0,num)+temp.substring(num+s2.length(),temp.length());
                        System.out.println("temp:"+temp);
                        break;
                    }
                    num+=1;
                }
            }
            if(temp.length() == 0){
                System.out.println(entry.getValue());
                result.add(entry.getKey());
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"aa","ca"};
        System.out.println(strings.length);
        List<Integer> list = new ArrayList<Integer>(5);
        String s = "acaaa";
        HardArithmetic arithmetic = new HardArithmetic();
        list = arithmetic.findSubstring(s,strings);
        for(Integer integer:list){
            System.out.println("result:"+integer);
        }
        String s1 = "caaa";
        System.out.println(s1.indexOf("ca",0));
    }
}
