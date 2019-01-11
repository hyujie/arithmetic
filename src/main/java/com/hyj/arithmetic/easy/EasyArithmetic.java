package com.hyj.arithmetic.easy;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @ Authord  yujie huang  email: 190158792@qq.com
 * @ Description
 * @ Date Create by in 11:02 2019/1/10
 */
public class EasyArithmetic {
    /**
     * 给定一个整数数组，返回两个数字的索引，使它们相加成为一个特定的目标。
     * 您可能假设每个输入只有一个解决方案，并且您可能不会两次使用相同的元素。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0;i<nums.length;i++){
            for(int n = i+1;n<nums.length;n++){
                int temp = nums[i]+nums[n];
                if(temp == target){
                    return new int[]{i,n};
                }
            }
        }
        return null;
    }


}
