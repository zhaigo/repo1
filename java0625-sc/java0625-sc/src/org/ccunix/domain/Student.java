package org.ccunix.domain;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 魏建波
 * Date:  2021/6/16
 * Time:  20:26
 * @description  学生类型
 */
public class Student {
    private String sno;
    private String name;
    private String sex;
    private int age;
    private double fileMoney;

    @Override
    public String toString() {
        return sno+"\t"+name+"\t"+sex+"\t"+age+"\t"+fileMoney;
    }

    public Student() {
    }

    public Student(String sno, String name, String sex, int age, double fileMoney) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.fileMoney = fileMoney;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getFileMoney() {
        return fileMoney;
    }

    public void setFileMoney(double fileMoney) {
        this.fileMoney = fileMoney;
    }
}