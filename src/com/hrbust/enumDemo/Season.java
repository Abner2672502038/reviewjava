package com.hrbust.enumDemo;

/**
 * @program: reviewJava
 * @description: 季节枚举类
 * @author: Abner
 * @create: 2020-03-10 19:59
 */
interface Info {
    void show();
}
public class Season {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        System.out.println(Season1.SUMMER);
        //values()
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
            value.show();
        }
        Season1 summer = Season1.valueOf("SUMMER");
        System.out.println(summer.getName());

    }
    //2.获得该类对象具有的属性,私有,不可更改
    private final String name;
    private final String desc;


    //1.建立私有构造器,并给属性赋值
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //3.创建有限个,确定的对象
    public static final Season SPRING = new Season("SPRING", "春暖花开");
    public static final Season SUMMER = new Season("SUMMER", "清爽夏季");
    public static final Season AUTUMN = new Season("AUTUMN", "秋天到了");
    public static final Season WINTER = new Season("WINTER", "白雪皑皑");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

enum Season1 implements Info{
    SPRING("SPRING", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天");
        }
    },
    SUMMER("SUMMER", "清爽夏季"){
        @Override
        public void show() {
            System.out.println("夏天");

        }
    },
    AUTUMN("AUTUMN", "秋天到了"){
        @Override
        public void show() {
            System.out.println("秋天");
        }
    },
    WINTER("WINTER", "白雪皑皑"){
        @Override
        public void show() {
            System.out.println("冬天");
        }
    };
        //2.获得该类对象具有的属性,私有,不可更改
        private final String name;
        private final String desc;

        //1.建立私有构造器,并给属性赋值
    private Season1(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }


}
