package practice;

import java.io.*;
import java.net.Socket;

/**
 * @author ：zht
 * @date ：Created in 2020/3/9 9:27
 * @description：
 * @modified By：
 * @version: $
 */
public class EchoClientDemo {
    public static void main(String[] args) {
        //创建一个socket对象，指定要连接的服务器
        try {
            Socket socket = new Socket("localhost",6666);
            //获取socket的输入输出流
            PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
            BufferedReader br= new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ps.println("hello");
            ps.flush();
            //读取服务器返回的数据
            String info = br.readLine();
            System.out.println(info);
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
