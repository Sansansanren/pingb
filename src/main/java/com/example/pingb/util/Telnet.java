package com.example.pingb.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Telnet {
	public static boolean telnetConnection(String hostname,Integer port) {
		try {
			Socket server = new Socket();
			InetSocketAddress address = new InetSocketAddress(hostname, port);
			server.connect(address, 10000);
			server.close();
			System.out.println("telnet success!");
			return true;
		} catch (UnknownHostException e) {
			System.out.println("请入输入正确的ip");
			return false;
		} catch (IOException e) {
			System.out.println("请输入正确的ip");
			return false;
		}
	}

}
