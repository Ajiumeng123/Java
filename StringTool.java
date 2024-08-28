/**
 * @半城烟火 2024.8.11
 * XOR字符串工具集合 version:1.0.0
 *希望可以帮到更多初学者,更好的保护字符串不被轻易的逆向
 * 持续更新中.....
 * -----------------------------------------
 * xorString为加密
 * UnxorString为解密
 * DwpString为检测违禁词
 * -----------------------------------------
 * @java后端开发
 */
package com.StringTool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringTool {
    private StringTool(){}
    public static String xorString(String str, int key){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            char xor = (char)(ch + key);
            sb.append(xor);
        }
        sb.reverse();
        return sb.toString();
    }
    public static String UnxorString(String str, int key){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            char xor = (char)(ch - key);
            sb.append(xor);
        }
        sb.reverse();
        return sb.toString();
    }
    public static void DpwString(String[] ifStr, String Str){
        int temp = 0;
        for (int i = 0; i < ifStr.length; i++){
            Pattern p = Pattern.compile(ifStr[i]);
            Matcher m = p.matcher(Str);
            while(m.find()){
                System.out.println("违禁词:" + m.group());
                temp++;
            }
        }
        System.out.println("违禁词总数:" + temp);
    }
}
