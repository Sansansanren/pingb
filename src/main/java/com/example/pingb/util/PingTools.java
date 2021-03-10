package com.example.pingb.util;

import java.net.InetAddress;

public class PingTools {
    public  static  boolean ping(String ipAddress)  throws Exception {
        int  timeOut =  3000 ;   // 超时应该在3钞以上
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);      //  当返回值是true时，说明host是可用的，false则不可。
        return status;
    }
}
