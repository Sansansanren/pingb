package com.example.pingb.controller;

import com.example.pingb.pojo.TelNet;
import com.example.pingb.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

@Controller
public class TelNetController {
    @CrossOrigin
    @PostMapping(value = "api/tellNet")
    @ResponseBody
    public Result tellNet(@RequestBody TelNet telNet) {
        // 对 html 标签进行转义，防止 XSS 攻击
     try{
     String ip = HtmlUtils.htmlEscape(telNet.getIp());
     String port = HtmlUtils.htmlEscape(telNet.getPort());

     if(ip.length()==0||port.length()==0){
         return new Result(100);
     }
         Socket server = new Socket();
         InetSocketAddress address = new InetSocketAddress(ip,Integer.valueOf(port));
         server.connect(address, 10000);
         server.close();
         return new Result(200);
     }catch (IllegalArgumentException illegalArgumentException){
         return new Result(301);
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
