package com.hrbust.collection.set;

import java.util.Objects;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-03-08 15:09
 */
public class Person {
    String name;
    int age;
    int id;
    String company;

    public Person(String name, int age, int id, String company) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.company = company;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return age == person.age &&
//                id == person.id &&
//                Objects.equals(name, person.name) &&
//                Objects.equals(company, person.company);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, id, company);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (id != person.id) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return company != null ? company.equals(person.company) : person.company == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + id;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
