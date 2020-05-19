package practice;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.sun.javafx.sg.prism.web.NGWebView;
import org.junit.Test;

import javax.xml.soap.Text;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zht
 * @date 2020-05-18 9:01
 */
public class JSONDemo2 {
    /*
    * 使用jsonReader解析复制的数据*/
    @Test
    public void parseJSONMessages(){
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("practice/message.json");
        InputStreamReader in = new InputStreamReader(is);
        JsonReader jsonReader = new JsonReader(in);
        ArrayList<Message> list = readMessageArray(jsonReader);
        for (Message m:list){
            System.out.println(m);
        }

    }
    //用来读取message数组
    private ArrayList<Message> readMessageArray(JsonReader jsonReader){
        ArrayList<Message> list = new ArrayList<>();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()){
               list.add(readMessage(jsonReader));
            }
            jsonReader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    //解析一个Message对象
    private Message readMessage(JsonReader jsonReader){
        Message m = new Message();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()){//此处解析到id
                String name = jsonReader.nextName();
                if ("id".equals(name)){
                    m.setId(jsonReader.nextLong());
                }else if ("text".equals(name)){
                    m.setText(jsonReader.nextString());
                }else if ("geo".equals(name)&&jsonReader.peek()!= JsonToken.NULL){//判断geo是否为null，为NUll直接跳过
                    m.setGeo(readGeo(jsonReader));
                }else if ("user".equals(name)){
                    m.setUser(readUser(jsonReader));
                }else {
                    jsonReader.skipValue();//跳过空值
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return m;
    }
    //解析Geo数组
    private ArrayList<Double> readGeo(JsonReader jsonReader){

        ArrayList<Double> list = new ArrayList<>();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()){
                list.add(jsonReader.nextDouble());//直接给list装值
            }
            jsonReader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    //解析User
    private User readUser(JsonReader jsonReader){
        User user = new User();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()){
                String name = jsonReader.nextName();
                if ("name".equals(name)){
                    user.setName(jsonReader.nextString());
                }else if("followers_count".equals(name)){
                    user.setFollowers_count(jsonReader.nextInt());
                }else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

}
