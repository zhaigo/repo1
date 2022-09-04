package org.ccunix.view;

import org.ccunix.domain.CourseManager;
import org.ccunix.utils.ScannerUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 魏建波
 * Date:  2021/6/23
 * Time:  17:20
 * @description
 */
public class MainView {
    public static void main(String[] args) {
        for(;;){
            System.out.println("------欢迎登录学生选课综合管理系统-----");
            System.out.println("------1、学生管理--------------");
            System.out.println("------2、课程管理-------------");
            System.out.println("------3、选课管理-------------");
            System.out.println("------0、退出当前模块----------");
            int key = ScannerUtil.getScannerInt();
            if(key==0){
                // 退出
                break;
            }
            switch (key){
                case 1:
                    StudentView.main(args);
                    break;
                case 2:
                    CourseView.main(args);
                    break;
                case 3:
                    StudentSelectCourseView.main(args);
                    break;
            }
        }
    }
}