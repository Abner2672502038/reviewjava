package com.hrbust.exception;

import java.io.*;

/**
 * @program: reviewJava
 * @description:异常处理
 * @author: Abner
 * @create: 2020-04-02 09:16
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println(test1());

    }
    public static int test1() throws NullPointerException{
      //java7之后的自动资源管理,需要类继承自AutoClosable
        /**
         * 注意throws和throw关键字
         */
        int a=0;
        try (FileInputStream fileInputStream = new FileInputStream("E:\\WorkSpace\\Inteljidea\\reviewJava\\src\\file\\环境变量配置4.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String s = bufferedReader.readLine();
            if (s == null) {
                return 0;
            }
             a= 10;
            return ++a;
            //所有异常类都继承自Throwable:
            /**
             * 异常分为:自检查异常:除了运行时异常
             *         运行时异常RuntimeException
             */

        } catch (Throwable e) {
            throw new MyException(e.getMessage());
        }finally {
            a +=10;
            return a;
        }
    }

}
