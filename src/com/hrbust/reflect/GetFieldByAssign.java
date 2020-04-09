package com.hrbust.reflect;

import java.lang.reflect.Field;

/**
 * @program: reviewJava
 * @description: 获取运行时类指定的属性
 * @author: Abner
 * @create: 2020-03-12 16:44
 */
public class GetFieldByAssign {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        //创建对象
        Person person = personClass.newInstance();
        //获取私有属性,当前运行时类的属性getField(String name);表示获取当前运行时类和父类中指定为age且为public的方法
        Field age = personClass.getDeclaredField("age");
       // 设置可访问
        age.setAccessible(true);
        //设置属性值,参数1:属于那个对象,参数2:形参的值
        age.set(person, 10);
        int num = (int) age.get(person);
        System.out.println(num);
    }
}
