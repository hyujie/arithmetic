package com.hyj.arithmetic.medium;

import com.hyj.arithmetic.easy.EasyArithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @ Authord  yujie huang  email: 190158792@qq.com
 * @ Description
 * @ Date Create by in 14:04 2019/1/11
 */
public class MediumArithmetic {


    /**
     * 给定一个字符串，查找不重复字符的最长子字符串的长度。
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring(String str){
        int maxLength = 0;
        char[] chars = str.toCharArray();
        for(int i = 0;i<chars.length;i++){
            Map<String,String> map = new HashMap<String,String>();
            for(int n = i;n<chars.length;n++){
                int temp = map.size();
                map.put(String.valueOf(chars[n]),"");
                if(temp == map.size()){
                    if(temp > maxLength){
                        maxLength = temp;
                    }
                    break;
                }
                if(n == chars.length - 1){
                    if(map.size()>maxLength){
                        maxLength = map.size();
                    }

                }
            }

        }

        return maxLength;
    }
    public static void main(String[] args) {
        MediumArithmetic arithmetic = new MediumArithmetic();
        String s = " ";
        char[] chars = s.toCharArray();
        System.out.println(s.length());
        int num = arithmetic.lengthOfLongestSubstring(s);
        System.out.println(num);
    }

}
