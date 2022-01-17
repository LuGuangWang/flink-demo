package com.wlg.tools;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NetCatTool {
    public static void main(String[] args) throws Exception{
        final int port = 12345;
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("["+dateFormat.format(new Date()) + "]" + socket.getInetAddress() + "已建立连接");

        OutputStream out = socket.getOutputStream();
        Scanner in = new Scanner(System.in);
        while(true){
            String str = in.nextLine() + "\n";
            out.write(str.getBytes());
            out.flush();
        }

    }

}
