package com.demo.java.xml.sax;

import com.alibaba.fastjson.JSON;
import com.demo.java.xml.TestOrg;
import com.demo.java.xml.TestOrgChildren;
import com.demo.java.xml.TestOrgParent;
import com.demo.java.xml.TestOrgs;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by maosheng on 2017/5/23.
 * TODO
 * 1.public static <T>T parseXML(String xml,Class<T> c)
 *   public static <T>T parseXML(String xml,T t){
 *   这两种方式都可以，哪种更好。
 * 2.Java泛型
 *
 */
public class JaxbUtil {
    /**
     * xml字符串转对象
     * @param clazz
     * @param context
     * @param <T>
     * @return
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T readString(Class<T> clazz, String context) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(new StringReader(context));
        } catch (JAXBException e) {
            throw e;
        }
    }

    /**
     * xml文件转对象
     * @param clazz
     * @param filePath
     * @param <T>
     * @return
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T readFile(Class<T> clazz, String filePath) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            throw e;
        }
    }

    /**
     * xml文件转对象，对象存在继承关系
     * @param clazz 父类
     * @param clazzChild 子类
     * @param filePath
     * @param <T>
     * @return
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T readFile(Class clazz,Class<T> clazzChild, String filePath) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz,clazzChild);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            throw e;
        }
    }

    /**
     * 不会用
     * @param clazz
     * @param config
     * @param arguments
     * @param <T>
     * @return
     * @throws IOException
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T readConfig(Class<T> clazz, String config, Object... arguments) throws IOException,JAXBException {
        InputStream is = null;
        try {
            if (arguments.length > 0) {
                config = MessageFormat.format(config, arguments);
            }
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            is = new FileInputStream(config);
            return (T) u.unmarshal(is);
        } catch (IOException e) {
            throw e;
        } catch (JAXBException e) {
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * 将输入流读取为对象。
     * 类必须被XmlRootElement和XmlAccessorType注解修饰
     * @param dataStream
     * @return
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T readConfigFromStream(Class<T> clazz, InputStream dataStream) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(dataStream);
        } catch (JAXBException e) {
            throw e;
        }
    }

    /**
     * 重载方法。将输入流读取为对象。
     * 类必须被XmlRootElement和XmlAccessorType注解修饰
     * @param clazz 父类
     * @param clazzChild 子类
     * @param dataStream 数据流
     * @param <T> 子类
     * @return
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T readConfigFromStream(Class clazz, Class<T> clazzChild, InputStream dataStream) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz,clazzChild);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(dataStream);
        } catch (JAXBException e) {
            throw e;
        }
    }

    /**
     * 数据流转xml字符串。
     */
    public static String readConfigFromStream(InputStream dataStream) throws JAXBException {
        try {
            SAXReader reader = new SAXReader();
            Document receiveXml = reader.read(dataStream);
            return receiveXml.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JavaBean转换成xml字符串
     * 默认编码UTF-8
     *
     * @param obj
     * @return
     */
    public static String convertToXmlstr(Object obj) {
        return convertToXmlstr(obj, "UTF-8");
    }

    /**
     * JavaBean转换成xml字符串
     *
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXmlstr(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            //决定是否在转换成xml时同时进行格式化（即按标签自动换行，否则即是一行的xml）。
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //xml的编码方式。
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();

            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) throws JAXBException {
        test4();
    }

    public static void test1() throws JAXBException {
        TestOrgChildren testOrgChildren = readFile(TestOrgParent.class,TestOrgChildren.class,"D:\\technology\\datasource\\mesen\\TestSSM\\src\\main\\java\\com\\demo\\java\\xml\\org");
        System.out.println(JSON.toJSONString(testOrgChildren));
    }

    public static void test2(){
        TestOrgChildren testOrgChildren = new TestOrgChildren();
        testOrgChildren.setOrgId(123L);
        testOrgChildren.setOrgCode("weimaosheng");
        testOrgChildren.setStartDate(new Date());

        System.out.println(convertToXmlstr(testOrgChildren));
    }

    public static void test3() throws JAXBException {
        TestOrgs testOrgs = readFile(TestOrgs.class,"D:\\technology\\datasource\\mesen\\TestSSM\\src\\main\\java\\com\\demo\\java\\xml\\orgs");
        System.out.println(JSON.toJSONString(testOrgs));
    }

    public static void test4() throws JAXBException {
        TestOrg testOrg1 = new TestOrg();
        testOrg1.setOrgCode("aaaaaa");
        testOrg1.setStartDate(new Date());

        TestOrg testOrg2 = new TestOrg();
        testOrg2.setOrgCode("bbbbbbbb");
        testOrg2.setStartDate(new Date());

        TestOrg testOrg3 = new TestOrg();
        testOrg3.setOrgCode("cccccccccc");
        testOrg3.setStartDate(new Date());

        List list = new ArrayList();
        list.add(testOrg1);
        list.add(testOrg2);
        list.add(testOrg3);

        TestOrgs testOrgs = new TestOrgs();
        testOrgs.setSize(123213213);
        testOrgs.setOrgs(list);

        System.out.println(convertToXmlstr(testOrgs));
    }
}
