package com.hyj.arithmetic.medium;
import java.util.*;

/**
 * @version 1.0
 * @authord  yujie huang  email: 190158792@qq.com
 * @ Description
 * @ Date Create by in 14:04 2019/1/11
 */
public class MediumArithmetic {


    /**
     * 给定一个字符串，查找不重复字符的最长子字符串的长度。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s){
        int maxLength = 0;
//        int m = 0;
//        for(int i = 0;i<s.length();i++){
//            Map<Character,String> map = new HashMap<Character,String>();
//            for(int n = i;n<s.length();n++){
//                int temp = map.size();
//                map.put(s.charAt(n),"");
//                if(temp == map.size()){
//                    maxLength = Math.max(temp,maxLength);
//                    break;
//                }
//                if(n == s.length() - 1){
//                    maxLength = Math.max(map.size(),maxLength);
//                    return maxLength;
//                }
//            }
//        }
        int n = s.length(), ans = 0;
        int endTemp = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(10);
        //gfsdvdfmefabe   pwwkew
        for(int i = 0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                ans  = ans >= (i - endTemp)?ans:(i - endTemp);
                endTemp = endTemp > map.get(s.charAt(i))?endTemp:map.get(s.charAt(i));
            }
            map.put(s.charAt(i),i+1);
        }
        ans = ans>= n - endTemp?ans:n-endTemp;
        return ans;
    }

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>(5);
        List<Integer> resultList = new ArrayList<Integer>(3);
        Map<Integer,Integer> result = new HashMap<Integer, Integer>(5);
        int num = 0;
        for(int i = nums.length-1;i>=0&&nums[i]>=0;i--){
            if(result.containsKey(0-nums[i])){
                continue;
            }
            result.put(0 - nums[i],i);
        }

        for(int i = 0;i<nums.length&& nums[i]<=0;i++){
            if(i>0&&nums[i] == nums[i-1]){
                continue;
            }
            for (int n = i+1;n<nums.length;n++){
                if(n != i+1&&nums[n] == nums[n-1]){
                    continue;
                }
                num = nums[i]+nums[n];
                if(result.containsKey(num)){
                    if(n < result.get(num)){
                        resultList.add(nums[i]);
                        resultList.add(nums[n]);
                        resultList.add(0-num);
                        lists.add(resultList);
                        resultList = new ArrayList<Integer>(3);
                    }
                }
            }


        }
        return lists;
    }


    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        Map<Character,List<Integer>> map = new HashMap<Character, List<Integer>>(10);
        String result = "";
        for(int i = 0;i<s.length();i++){
            String s1 = getLength(s,i,i);
            String s2 = getLength(s,i,i+1);
            result = result.length()>(s1.length()>s2.length()?s1:s2).length()?result:(s1.length()>s2.length()?s1:s2);
        }
        return result;
    }

    public String getLength(String s,int i,int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return s.substring(i+1,j);
            }
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }


    public static void main(String[] args) {
        MediumArithmetic arithmetic = new MediumArithmetic();
        System.out.println("abc".substring(1,3));         //adadabab
        System.out.println(arithmetic.longestPalindrome("babadada"));
      //  System.out.println(arithmetic.lengthOfLongestSubstring("abcabcbb"));
    }

}
