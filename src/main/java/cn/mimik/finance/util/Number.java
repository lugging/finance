package cn.mimik.finance.util;

import java.util.Random;

/**
 * Created by liugang on 2017/9/19.
 */
public class Number {

    public static String genRandomNum(int pwd_len){
        //10个数字
        final int  maxNum = 10;
        int i;  //生成的随机数
        int count = 0; //生成的密码的长度
        char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while(count < pwd_len){
            //生成随机数，取绝对值，防止生成负数，
            i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count ++;
            }
        }
        return pwd.toString();
    }

    public static String generCustNumber(){
        return genRandomNum(7);
    }

    public static void main(String [] args){
        System.out.println(generCustNumber());
    }
}
