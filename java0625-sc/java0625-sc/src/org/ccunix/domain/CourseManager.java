package org.ccunix.domain;

import org.ccunix.utils.ScannerUtil;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 魏建波
 * Date:  2021/6/20
 * Time:  10:53
 * @description
 */
public class CourseManager {
    private TreeSet<Course> courseTreeSet = new TreeSet();
    {
        // 构造代码块
        Course c1 = new Course("c1001","java",4,80,"2021-2022上学期","波波");
        Course c2 = new Course("c1002","框架",5,100,"2021-2022上学期","杰克");
        Course c3 = new Course("c1003","oracle",6,120,"2021-2022下学期","丽丽");
        Course c4 = new Course("c1004","jsp",5,100,"2021-2022下学期","汤姆");
        courseTreeSet.add(c1);
        courseTreeSet.add(c2);
        courseTreeSet.add(c3);
        courseTreeSet.add(c4);
    }
    public void add() {
        System.out.println("请输入课程号：");
        String cno = ScannerUtil.getScannerString();
        System.out.println("请输入课程名称：");
        String name = ScannerUtil.getScannerString();
        System.out.println("请输入学分：");
        double credit = ScannerUtil.getScannerDoube();
        System.out.println("请输入学时：");
        int hours = ScannerUtil.getScannerInt();
        System.out.println("请输入课程开课的学期：");
        String term = ScannerUtil.getScannerString();
        System.out.println("请输入授课教师名称：");
        String tName = ScannerUtil.getScannerString();
        // 创建一个课程对象
        Course course = new Course(cno, name, credit, hours, term, tName);
        // 添加到集合中
        courseTreeSet.add(course);
        System.out.println("------------课程添加成功------------");
    }

    // 验证课程是否存在
    public Course isExistCno(String cno) {
        // 遍历集合
        Iterator<Course> iterator = courseTreeSet.iterator();
        while (iterator.hasNext()) {
            Course c = iterator.next();
            if (c.getCno().equals(cno)) {
                return c;
            }
        }
        return null;
    }

    public void del() {
        System.out.println("请输入要删除的课程号：");
        String cno = ScannerUtil.getScannerString();
        // 验证该课程是否存在
        Course c = isExistCno(cno);
        if (c == null) {
            System.out.println("课程号输入有误，请重新输入");
            del();// 递归
        } else {
            // 删除对象
            courseTreeSet.remove(c);
            System.out.println("------------课程删除成功------------");
        }
    }

    public void update() {
        System.out.println("请输入要修改的课程号：");
        String cno = ScannerUtil.getScannerString();
        // 验证该课程是否存在
        Course c = isExistCno(cno);
        if (c == null) {
            System.out.println("课程号输入有误，请重新输入");
            update();// 递归
        } else {
            System.out.println("请输入课程号：");
            String cno1 = ScannerUtil.getScannerString();
            System.out.println("请输入课程名称：");
            String name = ScannerUtil.getScannerString();
            System.out.println("请输入学分：");
            double credit = ScannerUtil.getScannerDoube();
            System.out.println("请输入学时：");
            int hours = ScannerUtil.getScannerInt();
            System.out.println("请输入课程开课的学期：");
            String term = ScannerUtil.getScannerString();
            System.out.println("请输入授课教师名称：");
            String tName = ScannerUtil.getScannerString();
            // 开始修改
            c.setCno(cno1);
            c.setName(name);
            c.setCredit(credit);
            c.setHours(hours);
            c.setTerm(term);
            c.settName(tName);
            System.out.println("------------课程修改成功------------");
        }

    }

    public void queryAll() {
        // 遍历
        System.out.println("------------课程查询所有成功------------");
        System.out.println("课程名单如下：");
        Iterator<Course> iterator = courseTreeSet.iterator();
        System.out.println("课程号\t课程名\t学分\t学时\t学期\t教师名称");
        while (iterator.hasNext()) {
            Course c = iterator.next();
            System.out.println(c);
        }

    }

    public void queryByCno() {
        System.out.println("请输入要查询的课程号：");
        String cno = ScannerUtil.getScannerString();
        Course c = isExistCno(cno);
        if (c == null) {
            System.out.println("课程号输入有误，请重新输入");
            queryByCno();// 递归
        } else {
            System.out.println("------------课程按照课程号查询成功------------");
            System.out.println("课程号\t课程名\t学分\t学时\t学期\t教师名称");
            System.out.println(c);
        }
    }
}