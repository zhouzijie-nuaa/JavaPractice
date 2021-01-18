package com.zzj.file;

import java.io.File;

/**
 * author: zijiezhou
 * Date:   2020/9/6 15:49
 * Description:文件夹的操作
 */
public class FileDemo1 {
    public static void main(String[] args) {
        String filename = "D:"+ File.separator+"filepackage";
        File file = new File(filename);
        file.mkdir();//在对应的文件位置创建文件夹
        /*
        String[]str =file.list();//列出文件夹中的所有文件
        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
         file.listFiles();//列出所有文件，包括隐藏文件
         file。isDirectory();//判断指定路径是否是目录
        * */
    }
}
