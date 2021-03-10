package com.example.pingb.util;


import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Tools {
    public static void main(String[] args){
        System.out.println("输入Ip地址，可开始测试");
        for(int i=0;i<2;i=1){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ping:");
            String n = scanner.next();
            System.out.println("Test start ip:"+n);
            try{
                boolean flag = ping(n);
                if(flag){
                    System.out.println("Ping success");
                }else{
                    System.out.println("Ping failed");
                }
            }catch (Exception e){
                System.out.println("请输入正确的IP地址");
            }
        }
    }
    public  static  boolean ping(String ipAddress)  throws Exception {
        int  timeOut =  3000 ;   // 超时应该在3钞以上
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);      //  当返回值是true时，说明host是可用的，false则不可。
        return status;
    }
}
