package com.zzj.file;

import java.io.File;
import java.io.IOException;

/**
 * author: zijiezhou
 * Date:   2020/9/6 15:41
 * Description:对系统中的文件以及文件夹进行操作
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:\\file.txt");
        //双\\为转义
        try {
            file.createNewFile();
            System.out.println(File.pathSeparator);
            //;
            System.out.println(File.separator);
            //\
            /*删除文件
             File file = new File(filename);
            if(file.exists()){
                file.delete();
            }else{
                System.out.printlb("文件不存在")；
            }
            * */
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
