package org.ccunix.utils;

import java.util.Scanner;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 魏建波
 * Date:  2021/6/23
 * Time:  17:22
 * @description
 */
public class ScannerUtil {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 扫描一个int类型的值
     * @return
     */
    public static int getScannerInt(){
        return scanner.nextInt();
    }
    /**
     * 扫描一个double类型的值
     * @return
     */
    public static double getScannerDoube(){
        return scanner.nextDouble();
    }
    /**
     * 扫描一个String类型的值
     * @return
     */
    public static String getScannerString(){
        return scanner.next();
    }

    public static void main(String[] args) {
        String str = UUID.randomUUID().toString().replace("-","");
        System.out.println(str);
        System.out.println(str.length());
    }
}