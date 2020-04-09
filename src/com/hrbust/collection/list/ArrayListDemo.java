package com.hrbust.collection.list;

import java.util.*;

/**
 * @program: reviewJava
 * @description:源码分析
 * @author: Abner
 * @create: 2020-03-07 18:14
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<Object> objects1 = new ArrayList<>();
        Vector<Object> vector = new Vector<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        LinkedList<Object> objects2 = new LinkedList<>();
        objects2.add(7);
        objects2.add(8);
        objects2.addAll(objects);

       /* Iterator<Object> iter = objects.iterator();
        while(iter.hasNext()){
            Object obj = iter.next();
            if(obj.equals("Tom")){
                iter.remove();
            }
        }*/

    }

}
