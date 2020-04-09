package com.hrbust.newjava8.optional;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-03-15 14:42
 */
public class SupperBoy {
    Boy boy;

    public SupperBoy() {
    }

    public SupperBoy(Boy boy) {
        this.boy = boy;
    }

    public Boy getBoy() {
        return boy;
    }

    public void setBoy(Boy boy) {
        this.boy = boy;
    }

    @Override
    public String toString() {
        return "SupperBoy{" +
                "boy=" + boy +
                '}';
    }
}
