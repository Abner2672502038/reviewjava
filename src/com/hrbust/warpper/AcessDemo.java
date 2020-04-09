package com.hrbust.warpper;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-04-09 10:44
 */
public class AcessDemo {
    public int id;
    public String name;
    private String sex;
    private String school;

    public AcessDemo() {
    }

    public AcessDemo(int id, String name, String sex, String school) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.school = school;
    }

    @Override
    public String toString() {
        return "AcessDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public static void main(String[] args) {
        AcessDemo acessDemo = new AcessDemo(1, "HOST", "男", "哈理工");
        System.out.println(acessDemo.school);//同一类中private可访问
    }
}
