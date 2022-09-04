package org.ccunix.view;

import org.ccunix.domain.CourseManager;
import org.ccunix.domain.SCManager;
import org.ccunix.utils.ScannerUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 魏建波
 * Date:  2021/6/20
 * Time:  10:47
 * @description
 */
public class StudentSelectCourseView {
    static SCManager scManager = new SCManager();

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("------欢迎登录课程管理模块-----");
            System.out.println("------1、选课程--------------");
            System.out.println("------2、退课程-------------");
            System.out.println("------3、按照学号查询选课信息--------");
            System.out.println("------4、按照课程号查询学生信息------");
            System.out.println("------5、查询所有的选课信息------");
            System.out.println("------0、退出当前模块----------");
            int key = ScannerUtil.getScannerInt();
            if (key == 0) {
                // 退出
                break;
            }
            switch (key) {
                case 1:
                    scManager.selectCourse();
                    break;
                case 2:
                    scManager.deleteCourse();
                    break;
                case 3:
                    scManager.queryInfoBySno();
                    break;
                case 4:
                    scManager.queryInfoByCno();
                    break;
                case 5:
                    scManager.queryAll();
                    break;
            }
        }
    }
}