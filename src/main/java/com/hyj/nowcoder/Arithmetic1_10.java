package com.hyj.nowcoder;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 16:24 2019/2/15
 */
public class Arithmetic1_10 {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int [][] array) {

//        if(count < 0){
//            return false;
//        }
//        if(target<array[0][0] && target>array[array.length - 1][count]){
//            return false;
//        }
        int count =  array[0].length - 1;
        for(int i = 0;i<array.length;i++){
            while(count>=0&&array[i][count]>target){
                count--;
            }
            if(count>=0){
                if(array[i][count] == target){
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        //5,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        int[][] x = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}

        };
        System.out.println(find(6,x));
    }

}
