package org.ccunix.domain;

/**
 * Created with IntelliJ IDEA.
 *
 * 课程
 * @author 魏建波
 * Date:  2021/6/20
 * Time:  10:48
 * @description
 */
public class Course implements Comparable{
    private String cno;// 课程号
    private String name;// 课程名称
    private double credit;// 学分
    private int hours;// 学时
    private String term;// 学期
    private String tName;// 教师名称
    @Override
    public int compareTo(Object o) {
        return this.cno.compareTo(((Course)o).cno);
    }

    public Course() {
    }

    @Override
    public String toString() {
        return cno+"\t"+name+"\t"+credit+"\t"+hours+"\t"+term+"\t"+tName;
    }

    public Course(String cno, String name, double credit, int hours, String term, String tName) {
        this.cno = cno;
        this.name = name;
        this.credit = credit;
        this.hours = hours;
        this.term = term;
        this.tName = tName;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}