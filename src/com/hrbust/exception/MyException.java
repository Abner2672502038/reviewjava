package com.hrbust.exception;

/**
 * @program: reviewJava
 * @description:自定义异常
 * @author: Abner
 * @create: 2020-04-02 09:41
 */
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
