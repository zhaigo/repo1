package org.ccunix.domain;

import sun.security.krb5.internal.PAForUserEnc;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 魏建波
 * Date:  2021/6/23
 * Time:  18:44
 * @description
 */
public class SC {
    private int scNo; // 课程编号  唯一标识
    private Course course;//课程对象
    private Student student;//学生对象
    private double score;// 分数
    // 做一个方法  帮我把scNo自动增长
    private static int key = 0;
    public static int autoIncrementKey(){
        return ++key;
    }
    public int getScNo() {
        return scNo;
    }

    public void setScNo(int scNo) {
        this.scNo = scNo;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}