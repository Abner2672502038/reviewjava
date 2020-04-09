package com.hrbust.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-03-08 18:05
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Employee> treeSet = new TreeSet<>();
        Employee jack = new Employee("jack", 12, new MyDate(2000, 10, 5));
        Employee mary = new Employee("mary", 18, new MyDate(1980, 12, 5));
        Employee abner = new Employee("Abner", 21, new MyDate(2000, 10, 8));
        Employee tom = new Employee("tom", 45, new MyDate(2004, 9, 9));
        Employee simith = new Employee("simith", 89, new MyDate(2000, 3, 8));
        treeSet.add(jack);
        treeSet.add(mary);
        treeSet.add(abner);
        treeSet.add(tom);
        treeSet.add(simith);
        Iterator<Employee> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate birthday1 = o1.getBirthday();
                MyDate birthday2 = o2.getBirthday();
                int minYear = birthday1.getYear() - birthday2.getYear();
                if (minYear != 0) {
                    return minYear;
                }
                int minMonth = birthday1.getMonth() - birthday2.getMonth();
                if (minMonth != 0) {
                    return minMonth;
                }
                return birthday1.getDay() - birthday2.getDay();
            }
        };
        System.out.println("-------------------------------------");
        TreeSet<Employee> treeSet1 = new TreeSet<>(comparator);
        treeSet1.add(jack);
        treeSet1.add(mary);
        treeSet1.add(abner);
        treeSet1.add(tom);
        treeSet1.add(simith);
        Iterator<Employee> iterator1 = treeSet1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

}
