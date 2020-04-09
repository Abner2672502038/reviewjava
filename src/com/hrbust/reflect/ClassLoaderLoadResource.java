package com.hrbust.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: reviewJava
 * @description: 类加载器加载配置文件
 * @author: Abner
 * @create: 2020-03-11 17:08
 */
public class ClassLoaderLoadResource {
    public static void main(String[] args) {
        //方法一,用集合框架,//流默认找的是当前moudle下
         InputStream fis = null;
        try {
            Properties properties = new Properties();
           /*fis = new FileInputStream("jdbc.properties");
            properties.load(fis);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            System.out.println("user=" + user + "\t" + "password=" + password);*/
            //方法二:用类加载器,默认找的是当前moudle的src下
            ClassLoader classLoader = ClassLoaderLoadResource.class.getClassLoader();
            fis = classLoader.getResourceAsStream("jdbc1.properties");
            properties.load(fis);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            System.out.println("user=" + user + "\t" + "password=" + password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
