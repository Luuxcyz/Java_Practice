package com.luu.util;

/**
 * @author Guan
 * @date 2024/3/14 14:35
 */
public class Print {
    public static void print(String line){
        char[] lines = line.toCharArray();
        for (char c:lines) {
            System.out.print(c);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

}
