package org.ccunix.view;

import org.ccunix.domain.CourseManager;
import org.ccunix.domain.StudentManager;
import org.ccunix.utils.ScannerUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 魏建波
 * Date:  2021/6/20
 * Time:  10:47
 * @description
 */
public class CourseView {
    public static CourseManager courseManager = new CourseManager();
    public static void main(String[] args) {
        for(;;){
            System.out.println("------欢迎登录课程管理模块-----");
            System.out.println("------1、添加课程--------------");
            System.out.println("------2、删除课程-------------");
            System.out.println("------3、修改课程-------------");
            System.out.println("------4、查询所有课程---------");
            System.out.println("------5、按照课程号查询课程------");
            System.out.println("------0、退出当前模块----------");
            int key = ScannerUtil.getScannerInt();
            if(key==0){
                // 退出
                break;
            }
            switch (key){
                case 1:
                    courseManager.add();
                    break;
                case 2:
                    courseManager.del();
                    break;
                case 3:
                    courseManager.update();
                    break;
                case 4:
                    courseManager.queryAll();
                    break;
                case 5:
                    courseManager.queryByCno();
                    break;
            }
        }
    }
}