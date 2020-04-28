package Communication;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author ：zht
 * @date ：Created in 2020/3/17 8:36
 * @description：
 * @modified By：
 * @version: $
 */

//URL 统一资源定位符
public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://i0.hdslb.com/bfs/album/139ccd30c097cff0482fbba589adea36c86283e0.png");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("F:\\IDEA\\src\\Communication\\111.jpg"));
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len=in.read(bytes))!=-1){
                out.write(bytes,0,len);
                out.flush();
            }
            in.close();
            out.close();
            System.out.println("下载成功");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
