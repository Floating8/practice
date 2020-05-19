package practice;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zht
 * @date 2020-05-19 8:34
 */

/*
* 数据传输：json要比xml更有优势
* 存储数据：xml描述性更强
* xml通常用作配置文件*/

public class JsonDemo3 {

    @Test
    /*把一组json对象转换成java对象集合或者把一个Java对象集合转换成json数组*/
    public void gson2(){
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("practice/names.json");
        InputStreamReader in = new InputStreamReader(is);
        TypeToken<List<Name>> typeToken = new TypeToken<List<Name>>(){};
        Object list = gson.fromJson(in, typeToken.getType());
        System.out.println(list);

        String json = gson.toJson(list, typeToken.getType());
        System.out.println(json);
    }

    /*
    * 把一个json对象转换成JAVA对象，或把一个Java对象转换成JSON对象*/
    @Test
    public void gson1(){
        Gson gson = new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("practice/name.json");
        InputStreamReader in = new InputStreamReader(is);
        Name name = gson.fromJson(in, Name.class);
        System.out.println(name);

        String json = gson.toJson(name);//转化成json对象
        System.out.println(json);
    }

    @Test
    public void createJSON(){
        List<Name> list = new ArrayList<>();
        list.add(new Name("ss","aa","asdsda"));
        list.add(new Name("dd","ww","4546"));
        JsonArray array = new JsonArray();
        for (Name n:list){
            JsonObject obj = new JsonObject();
            obj.addProperty("firstName",n.getFirstName());
            obj.addProperty("lastName",n.getLastName());
            obj.addProperty("email",n.getEmail());
            array.add(obj);
        }
        System.out.println(array.toString());
    }
}
