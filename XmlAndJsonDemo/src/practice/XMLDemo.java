package practice;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.hamcrest.core.Is;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author zht
 * @date 2020-05-11 10:26
 */
public class XMLDemo {

    /*
    * 使用第三方xStream组件实现XML的解析与生成*/
    @Test
    public void xStream(){
        Person p = new Person();
        p.setPersonid("111");
        p.setAddress("wsw");
        p.setEmail("@123");
        p.setTel("563");
        p.setFax("135156");
        p.setName("dsa");

        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("xx",Person.class);//取别名
        xStream.useAttributeFor(Person.class,"personid");
        String xml = xStream.toXML(p);
        System.out.println(xml);


        //解析XML
        Person  person= (Person)xStream.fromXML(xml);
        System.out.println(person);
    }


    /*
    * 从XML文件中读取对象*/
    @Test
    public void xmlDeCoder() throws FileNotFoundException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("test.xml"));
        XMLDecoder decoder = new XMLDecoder(in);
        Person person = (Person) decoder.readObject();
        System.out.println(person);
    }

/*把对象转成XML文件写入
* */
    @Test
    public void xmlEnCoder() throws FileNotFoundException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        Person p = new Person();
        p.setPersonid("111");
        p.setAddress("wsw");
        p.setEmail("@123");
        p.setTel("563");
        p.setFax("135156");
        p.setName("dsa");
        xmlEncoder.writeObject(p);
        xmlEncoder.close();
    }


    /*DMO4J解析XML
    基于树型结构，第三方组件
    解析速度快，效率更高，使用的JAVA的迭代器实现数据读取，在web框架中使用较多（Hibernate）
    * */
    @Test
    public void dom4jParseXML() throws DocumentException {
        //创建DMO4J的解析器对象
        SAXReader reader = new SAXReader();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("practice/person.xml");
        org.dom4j.Document doc = reader.read(is);//返回的文档
        org.dom4j.Element rootElement = doc.getRootElement();
        Iterator<org.dom4j.Element> iterator = rootElement.elementIterator();
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;
        while (iterator.hasNext()){
            p = new Person();
            org.dom4j.Element e = iterator.next();
            p.setPersonid(e.attributeValue("personid"));
            Iterator<org.dom4j.Element> iterator1 = e.elementIterator();
            while(iterator1.hasNext()){
                org.dom4j.Element next = iterator1.next();
                String tag = next.getName();
                if ("name".equals(tag)){
                    p.setName(next.getText());
                }else if ("address".equals(tag)){
                    p.setAddress(next.getText());
                }else if ("tel".equals(tag)){
                    p.setTel(next.getText());
                }else if ("fax".equals(tag)){
                    p.setFax(next.getText());
                }else if ("email".equals(tag)){
                    p.setEmail(next.getText());
                }
            }
            persons.add(p);
        }
        System.out.println(Arrays.toString(persons.toArray()));
    }


    /*
    * JDOM解析XML
    * 1：与DMO类似，基于树形结构
    * 2：区别：
    *       1：第三方开源组件
    *       2：实现使用JAVA的collectio接口
    *       3：效率比DMO更快*/
    @Test
    public void jdomParseXML() throws JDOMException, IOException {
        //创建JDOM解析器
        SAXBuilder builder = new SAXBuilder();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("practice/person.xml");
        org.jdom2.Document build = builder.build(is);//此处返回一个文档对象
        Element rootElement = build.getRootElement();//获取根节点
        List<Person> list = new ArrayList<>();
        Person person = null;
        List<Element> children = rootElement.getChildren();
        for (Element element :children){
            person = new Person();
            String personid = element.getAttributeValue("personid");
            person.setPersonid(personid);
            List<Element> children1 = element.getChildren();
            for (Element e : children1){
                String tag = e.getName();
                if ("name".equals(tag)){
                    person.setName(e.getText());
                }else if ("address".equals(tag)){
                    person.setAddress(e.getText());
                }else if ("tel".equals(tag)){
                    person.setTel(e.getText());
                }else if ("fax".equals(tag)){
                    person.setFax(e.getText());
                }else if ("email".equals(tag)){
                    person.setEmail(e.getText());
                }
            }
            list.add(person);
        }
        System.out.println("结果：");
        System.out.println(Arrays.toString(list.toArray()));
    }

    /*
    * DMO解析XML
    * 1.基于树型结构，通过解析器一次性把文档加载到内存中，所以比较占用内存，可以随机访问
    * 更加灵活，更适合在WEB开发中使用*/
    @Test
    public void domParseXML() throws ParserConfigurationException, IOException, SAXException {
        //1.创建一个DMO解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.通过工厂对象创建解析器对象
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        //3.解析文档
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("practice/person.xml");
        Document doc = documentBuilder.parse(is);//此代码完成后，整个XML文档已经被加载到内存中，以树状存储
        //4.从内存中读取数据
        //获取节点名称为person的所有节点，返回节点集合
        NodeList personNodeList = doc.getElementsByTagName("person");
        ArrayList<Person> persons = new ArrayList<>();
        Person p = null;
        //此循环会迭代两次
        for (int i = 0; i < personNodeList.getLength(); i++) {
            Node personNode = personNodeList.item(i);//返回的是一个person节点
            p = new Person();
            //获取节点的属性值
            String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
            p.setPersonid(personid);
            //获取当前节点的所有子节点
            NodeList childNodes = personNode.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if ("name".equals(nodeName)) {
                    p.setName(item.getFirstChild().getNodeValue());
                }else if ("address".equals(nodeName)){
                    p.setAddress(item.getFirstChild().getNodeValue());
                }else if ("tel".equals(nodeName)){
                    p.setTel(item.getFirstChild().getNodeValue());
                }else if ("fax".equals(nodeName)){
                    p.setFax(item.getFirstChild().getNodeValue());
                }else if ("email".equals(nodeName)){
                    p.setEmail(item.getFirstChild().getNodeValue());
                }

            }
            persons.add(p);
        }
        System.out.println("结果：");
        System.out.println(Arrays.toString(persons.toArray()));
    }

    /*SAX解析特点：
1：基于事件驱动
2：顺序读取，速度快
3：不能任意读取节点（灵活性较差）
4：解析时占用的内存小
5：sax更适用于在性能要求更高的设备上使用（Android）*/
    @Test
    public void saxParseXML() throws ParserConfigurationException, SAXException, IOException {
        //1，创建一个SAX解析器工厂对象
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2，通过工厂对象创建SAX解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //3，创建一个数据处理器（需要我们自己编写）
        PersonHandler personHandler = new PersonHandler();
        //4，开始解析
        InputStream is = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("practice/person.xml");
        saxParser.parse(is,personHandler);

        List<Person> persons = personHandler.getPersons();
        for(Person p : persons){
            //增强for循环，将persons里放的是Person的对象，一个一个遍历出来，循环赋值给p
            System.out.println(p);
        }
        /*
        * 相当于
        * for(int i=0;i<persons.size();i++){
        * Person p = persons.get(i)
        * }
        * */

    }
}
