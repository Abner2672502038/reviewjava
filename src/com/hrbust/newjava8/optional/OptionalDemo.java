package com.hrbust.newjava8.optional;

import java.util.Optional;

/**
 * @program: reviewJava
 * @description: Optional类
 * @author: Abner
 * @create: 2020-03-15 14:38
 */
public class OptionalDemo {
    public static void main(String[] args) {
        test1();
    }

    /**
     * Optional其实是对对象的一个包装
     */
    public static void test1() {

        SupperBoy supperBoy = new SupperBoy();
        Optional<SupperBoy> supperBoy1 = Optional.ofNullable(supperBoy);
        SupperBoy supperBoy2 = supperBoy1.orElse(new SupperBoy());
        Boy boy = supperBoy2.getBoy();
        Optional<Boy> boy1 = Optional.ofNullable(boy);
        Boy host = boy1.orElse(new Boy("host", 20));
        System.out.println(host.getName());
    }

}
