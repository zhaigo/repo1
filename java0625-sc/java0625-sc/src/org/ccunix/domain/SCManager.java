package org.ccunix.domain;

import org.ccunix.utils.ScannerUtil;
import org.ccunix.view.CourseView;
import org.ccunix.view.StudentView;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * 选课管理
 *
 * @author 魏建波
 * Date:  2021/6/23
 * Time:  18:53
 * @description
 */
public class SCManager {
    /**
     * 选课
     */
    private Hashtable<String, SC> studentSelectCourseHashtable = new Hashtable<>();

    public void selectCourse() {
        // 先得知道开了什么课程
        CourseView.courseManager.queryAll();
        System.out.println("请输入您要选择得课程编号：");
        String cno = ScannerUtil.getScannerString();
        // 获得课程
        Course c = CourseView.courseManager.isExistCno(cno);
        while (c == null) {
            System.out.println("您输入得课程有误，请重新输入？？？如需要退出请输入0");
            cno = ScannerUtil.getScannerString();
            if ("0".equals(cno))
                return;
            c = CourseView.courseManager.isExistCno(cno);
        }
        // 显示选课的学生
        StudentView.studentManager.queryAll();
        // 继续执行
        System.out.println("请输入要选课的学生学号：");
        String sno = ScannerUtil.getScannerString();
        Student s = StudentView.studentManager.isExistSno(sno);
        while (s == null) {
            System.out.println("您输入的学号有误，请重新输入？？？如需要退出请输入0");
            sno = ScannerUtil.getScannerString();
            if ("0".equals(sno))
                return;
            s = StudentView.studentManager.isExistSno(sno);
        }
        // 继续执行
        boolean b = isExistSelectCourse(c, s);
        if (b) {
            System.out.println("该课程已经被该学生选过了，无需重复选择！！！");
        } else {
            SC sc = new SC();
            sc.setScNo(SC.autoIncrementKey());
            sc.setCourse(c);
            sc.setStudent(s);
            // 验证该课程和学生是否在选课列表中
            studentSelectCourseHashtable.put(String.valueOf(sc.getScNo()), sc);
            System.out.println("选课成功");
        }
    }

    // 查询某个课程选择的学生信息列表
    public List<Student> queryStudentByCno(String cno) {
        List<Student> selectStudentList = new ArrayList<>();
        // 根据cno获得学生信息
        Course course = CourseView.courseManager.isExistCno(cno);
        // 遍历studentSelectCourseHashtable 查询选择学生的信息
        Collection<SC> scCollection = studentSelectCourseHashtable.values();
        // 迭代器
        for (Iterator<SC> iterator = scCollection.iterator(); iterator.hasNext(); ) {
            SC sc = iterator.next();
            if (sc.getCourse() == course) {
                // 该选课中的学生信息  你就要了
                selectStudentList.add(sc.getStudent());
            }
        }
        return selectStudentList;
    }
    // 查询某个学生选择的课程信息列表
    private List<Course> queryCourseBySno(String sno) {
        List<Course> selectCourseList = new ArrayList<>();
        Student student = StudentView.studentManager.isExistSno(sno);
        // 遍历studentSelectCourseHashtable 查询选择学生的信息
        Collection<SC> scCollection = studentSelectCourseHashtable.values();
        // 迭代器
        for (Iterator<SC> iterator = scCollection.iterator(); iterator.hasNext(); ) {
            SC sc = iterator.next();
            if (sc.getStudent()== student) {
                // 该选课中的课程信息  你就要了
                selectCourseList.add(sc.getCourse());
            }
        }
        return selectCourseList;
    }

    public boolean isExistSelectCourse(Course c, Student s) {
        // 遍历studentSelectCourseHashtable 的值
        Collection<SC> values = studentSelectCourseHashtable.values();
        // 迭代器
        for (Iterator<SC> iterator = values.iterator(); iterator.hasNext(); ) {
            SC sc = iterator.next();
            if (sc.getCourse() == c && sc.getStudent() == s) {
                return true;
            }
        }
        return false;
    }


    public void queryAll() {
        // 遍历studentSelectCourseHashtable 的值
        Collection<SC> values = studentSelectCourseHashtable.values();
        System.out.println("选课信息列表如下：");
        System.out.println("学号\t姓名\t性别\t年龄\t生活费\t课程号\t课程名\t学分\t学时\t学期\t教师名称");
        // 迭代器
        for (Iterator<SC> iterator = values.iterator(); iterator.hasNext(); ) {
            SC sc = iterator.next();
            System.out.print(sc.getStudent() + "\t");
            System.out.println(sc.getCourse());
        }
    }

    // 退课
    public void deleteCourse() {
        // 查询所有课程
        CourseView.courseManager.queryAll();
        System.out.println("请输入您要删除的课程编号：");
        String cno = ScannerUtil.getScannerString();
        // 获得课程
        Course c = CourseView.courseManager.isExistCno(cno);
        while (c == null) {
            System.out.println("您输入得课程有误，请重新输入？？？如需要退出请输入0");
            cno = ScannerUtil.getScannerString();
            if ("0".equals(cno))
                return;
            c = CourseView.courseManager.isExistCno(cno);
        }
        // 显示选择该门课程的学生信息
        List<Student> selectStudentList = queryStudentByCno(cno);
        System.out.println("选择" + c.getName() + "课程的学生名单如下：");
        System.out.println("学号\t姓名\t性别\t年龄\t生活费");
        // 遍历
        for (Student s : selectStudentList) {
            System.out.println(s);
        }
        if (selectStudentList.size() == 0) {
            System.out.println("没有任何学生选择了该门课程！！！");
        } else {
            // 退选
            System.out.println("请输入要退选该门课程的学生编号？？？？");
            String deleteSno = ScannerUtil.getScannerString();
            // 验证学号是否存在
            Student s = StudentView.studentManager.isExistSno(deleteSno);
            while (s == null) {
                System.out.println("您输入的学号有误，请重新输入？？？如需要退出请输入0");
                deleteSno = ScannerUtil.getScannerString();
                if ("0".equals(deleteSno))
                    return;
                s = StudentView.studentManager.isExistSno(deleteSno);
            }
            // 验证该学生是否选择了该门课程
            boolean b = isExistSelectCourse(c, s);
            if (b) {
                // 可以删除课程和学生对应信息
                boolean b2 = removeSc(c, s);
                if(b2==true){
                    System.out.println(s.getSno()+"把"+c.getName()+"课程退选成功！！！");
                }else{
                    System.out.println(s.getSno()+"把"+c.getName()+"课程退选失败！！！");
                }
            } else {
                System.out.println("学生没有选择该门课程，无需进行删除操作");
            }
        }
    }

    private boolean removeSc(Course c, Student s) {
        Collection<SC> values = studentSelectCourseHashtable.values();
        // 迭代器
        for (Iterator<SC> iterator = values.iterator(); iterator.hasNext(); ) {
            SC sc = iterator.next();
            if (sc.getCourse()==c && sc.getStudent()==s) {
                // 刪除
                studentSelectCourseHashtable.remove(String.valueOf(sc.getScNo()));
                return true;
            }
        }
        return true;
    }
    // 根据学号查询该学生选择的课课信息
    public void queryInfoBySno() {
        System.out.println("请输入学生学号？？");
        String sno = ScannerUtil.getScannerString();
        // 验证是否存在
        Student s = StudentView.studentManager.isExistSno(sno);
        while (s == null) {
            System.out.println("您输入的学号有误，请重新输入？？？如需要退出请输入0");
            sno = ScannerUtil.getScannerString();
            if ("0".equals(sno))
                return;
            s = StudentView.studentManager.isExistSno(sno);
        }
        // 查询该学生选择哪些门课
        List<Course> selectCourseList = queryCourseBySno(sno);
        // 遍历
        System.out.println("学生：" + s.getName() + "选择的课程列表名单如下：");
        System.out.println("课程号\t课程名\t学分\t学时\t学期\t教师名称");
        for(Course c:selectCourseList){
            System.out.println(c);
        }
        if (selectCourseList.size() == 0) {
            System.out.println("该学生没有选择任何的课程！！！");
        }
    }


    // 根据课程号查询选择该课程的学生信息
    public void queryInfoByCno() {
        System.out.println("请输入课程编号？？");
        String cno = ScannerUtil.getScannerString();
        // 验证课程编号是否存在
        // 获得课程
        Course c = CourseView.courseManager.isExistCno(cno);
        while (c == null) {
            System.out.println("您输入得课程有误，请重新输入？？？如需要退出请输入0");
            cno = ScannerUtil.getScannerString();
            if ("0".equals(cno))
                return;
            c = CourseView.courseManager.isExistCno(cno);
        }
        // 调用
        List<Student> selectStudentList = queryStudentByCno(cno);
        // 遍历
        System.out.println("选择" + c.getName() + "课程的学生名单如下：");
        System.out.println("学号\t姓名\t性别\t年龄\t生活费");
        // 遍历
        for (Student s : selectStudentList) {
            System.out.println(s);
        }
        if (selectStudentList.size() == 0) {
            System.out.println("没有任何学生选择了该门课程！！！");
        }
    }
}