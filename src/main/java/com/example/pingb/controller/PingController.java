package com.example.pingb.controller;


import com.example.pingb.pojo.Ping;
import com.example.pingb.result.Result;
import com.example.pingb.util.PingTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
    public class PingController {
    @CrossOrigin
    @PostMapping(value = "api/ping")
    @ResponseBody
    public Result ping(@RequestBody Ping requestPing) {
        // 对 html 标签进行转义，防止 XSS 攻击
        try {
            String ping = requestPing.getPing();
            ping = HtmlUtils.htmlEscape(ping);
            if(ping.length()==0){
                return new Result(401);
            }
            int timeOut = 3000;   // 超时应该在3钞以上
            boolean status = InetAddress.getByName(ping).isReachable(timeOut);      //  当返回值是true时，说明host是可用的，false则不可。
         if(status){
             return new Result(100);
         }else{
             return new Result(200);
         }
        }catch (UnknownHostException unknownHostException){
            return new Result(300);

        } catch (Exception e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String errorINfo = sw.toString();
            return new Result(errorINfo,404);
        }
    }
}


