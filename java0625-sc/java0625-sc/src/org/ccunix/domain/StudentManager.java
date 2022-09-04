package org.ccunix.domain;

import org.ccunix.utils.ScannerUtil;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 魏建波
 * Date:  2021/6/16
 * Time:  20:28
 * @description 学生管理类型
 */
public class StudentManager {
    private ArrayList studentList = new ArrayList();
    {
        Student s1 = new Student("20181101","王翔","男",20,2000);
        Student s2 = new Student("20181102","一迪","男",21,2500);
        Student s3 = new Student("20181103","孙可","男",19,2300);
        Student s4 = new Student("20181104","罗健","男",20,2400);
        Student s5 = new Student("20181105","彭景","男",19,2200);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
    }
    public void add(){
        System.out.println("请输入学号：");
        String sno = ScannerUtil.getScannerString();
        System.out.println("请输入姓名：");
        String name = ScannerUtil.getScannerString();
        System.out.println("请输入性别：");
        String sex = ScannerUtil.getScannerString();
        System.out.println("请输入年龄：");
        int age = ScannerUtil.getScannerInt();
        System.out.println("请输入生活费：");
        double fileMoney = ScannerUtil.getScannerDoube();
        // 组装对象
        Student student = new Student(sno,name,sex,age,fileMoney);
        // 添加到集合中
        studentList.add(student);
        System.out.println("------------学生添加成功------------");
    }
    // 验证学生是否存在
    public Student isExistSno(String sno){
        // 遍历集合
        for(int i=0;i<studentList.size();i++){
            Student student = (Student)studentList.get(i);
            if(student.getSno().equals(sno)){
                return student;// 存在
            }
        }
        return null;
    }
    public void del(){
        System.out.println("请输入要删除学生的学号：");
        String sno = ScannerUtil.getScannerString();
        // 验证该学生是否存在
        Student s = isExistSno(sno);
        if(s==null){
            System.out.println("学号输入有误，请重新输入");
            del();// 递归
        }else{
            studentList.remove(s);
            System.out.println("------------学生删除成功------------");
        }
    }
    public void update(){
        System.out.println("请输入要修改学生的学号：");
        String sno = ScannerUtil.getScannerString();
        // 验证该学生是否存在
        Student s = isExistSno(sno);
        if(s==null){
            System.out.println("学号输入有误，请重新输入");
            update();// 递归
        }else{
            System.out.println("请输入学号：");
            String sno1 = ScannerUtil.getScannerString();
            System.out.println("请输入姓名：");
            String name = ScannerUtil.getScannerString();
            System.out.println("请输入性别：");
            String sex = ScannerUtil.getScannerString();
            System.out.println("请输入年龄：");
            int age = ScannerUtil.getScannerInt();
            System.out.println("请输入生活费：");
            double fileMoney = ScannerUtil.getScannerDoube();
            // 开始修改
            s.setSno(sno1);
            s.setName(name);
            s.setSex(sex);
            s.setAge(age);
            s.setFileMoney(fileMoney);
            System.out.println("------------学生修改成功------------");
        }

    }
    public void queryAll(){
        // 遍历
        System.out.println("------------学生查询所有成功------------");
        System.out.println("学生名单如下：");
        System.out.println("学号\t姓名\t性别\t年龄\t生活费");
        for(int i=0;i<studentList.size();i++){
            Student student = (Student)studentList.get(i);
            System.out.println(student.toString());
        }
    }
    public void queryBySno(){
        System.out.println("请输入要查询学生的学号：");
        String sno = ScannerUtil.getScannerString();
        Student s = isExistSno(sno);
        if(s==null){
            System.out.println("学号输入有误，请重新输入");
            queryBySno();// 递归
        }else{
            System.out.println("------------学生按照学号查询成功------------");
            System.out.println("学号\t姓名\t性别\t年龄\t生活费");
            System.out.println(s);
        }
    }
}