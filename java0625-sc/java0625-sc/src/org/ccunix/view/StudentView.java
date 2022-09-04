package org.ccunix.view;

import org.ccunix.domain.StudentManager;
import org.ccunix.utils.ScannerUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 魏建波
 * Date:  2021/6/16
 * Time:  20:31
 * @description
 */
public class StudentView {
    public static StudentManager  studentManager = new StudentManager();
    public static void main(String[] args) {
        for(;;){
            System.out.println("------欢迎登录学生管理模块-----");
            System.out.println("------1、添加学生--------------");
            System.out.println("------2、删除学生-------------");
            System.out.println("------3、修改学生-------------");
            System.out.println("------4、查询所有学生---------");
            System.out.println("------5、按照学号查询学生------");
            System.out.println("------0、退出当前模块----------");
            int key = ScannerUtil.getScannerInt();
            if(key==0){
                // 退出
                break;
            }
            switch (key){
                case 1:
                    studentManager.add();
                    break;
                case 2:
                    studentManager.del();
                    break;
                case 3:
                    studentManager.update();
                    break;
                case 4:
                    studentManager.queryAll();
                    break;
                case 5:
                    studentManager.queryBySno();
                    break;
            }
        }
    }
}