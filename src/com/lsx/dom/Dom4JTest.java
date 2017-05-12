package com.lsx.dom;

import java.io.File;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4JTest {
	  //测试读取xml文件并-----》xml字符串
	   @Test  
	    public void test5()throws Exception{  
	        //创建SAXReader对象  
	        SAXReader reader = new SAXReader();  
	        //读取文件 转换成Document  
	        Document document = reader.read(new File("src/res/book.xml"));  
	        //document转换为String字符串  
	        String documentStr = document.asXML();  
	        System.out.println("document 字符串：" + documentStr);  
	        //获取根节点  
	        Element root = document.getRootElement();  
	        //根节点转换为String字符串  
	        String rootStr = root.asXML();  
	        System.out.println("root 字符串：" + rootStr);  
	        //获取其中第一个book节点  
	        Element student1Node = root.element("book");  
	        //book节点转换为String字符串  
	        String student1Str = student1Node.asXML();  
	        System.out.println("student1 字符串：" + student1Str);  
	    }
	   //获取读取xml字符串
	   @Test
	   public void test2() {
			String xml = "<KV><Headline><![CDATA[]]></Headline><AlternateHeadline><![CDATA[]]></AlternateHeadline><AlternateDescription><![CDATA[]]></AlternateDescription><Description><![CDATA[]]></Description><JPG-320X320-NODELIST>/node/1-JPG-320X320-NODE.jpg</JPG-320X320-NODELIST><JPG-600X600-NODELIST>/node/1-JPG-600X600-NODE.jpg</JPG-600X600-NODELIST><JPG-NXN-NODELIST>/node/1-JPG-NXN-NODE.jpg</JPG-NXN-NODELIST></KV>";
			SAXReader reader;
			Document doc = null;
			reader = new SAXReader();
			reader.setValidation(false);
			try {
				doc = reader.read(new StringReader(xml));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//難點
			System.out.println("document"+doc.asXML());
			//这里报错java.lang.NoClassDefFoundError: org/jaxen/JaxenException
			//这是因为我只引入了核心jar包，少了依赖jar包
			Node n = doc.selectSingleNode("KV/JPG-320X320-NODELIST");
			String s = n.getStringValue();
			System.out.println("节点值："+s);

	 //设置节点值
	 //
		doc.selectSingleNode("KV/JPG-320X320-NODELIST").setText("ammmmm");
			Node n1 = doc.selectSingleNode("KV/JPG-320X320-NODELIST");
			System.out.println(n1.getStringValue());
	// 设置属性值
		Element rootE = doc.getRootElement();
	     //这是设置属性节点,没有的话是添加并设值
		rootE.setAttributeValue("JPG-320X320-NODELIST","wwww");
		//移除属性节点
		rootE.remove(rootE.attribute("JPG-320X320-NODELIST"));
	
			doc.setRootElement(rootE);
			System.out.println(doc.asXML());
            System.out.println("设置值："+doc.selectSingleNode("KV/JPG-320X320-NODELIST").getText());

		}


	   
	public static void main(String[] args) {
     SAXReader reader=new SAXReader();
     try {
		Document document = reader.read(new File("src/res/book.xml"));
	    //获取根节点books
		Element rootElement = document.getRootElement();
		Iterator iterator = rootElement.elementIterator();
		//遍历迭代器
		while(iterator.hasNext()){
			//将object--->Element  book
			Element e = (Element)iterator.next();
			//如果已知属性名
			String value = e.attributeValue("id");
			System.out.println("属性名值："+value);
			//获取属性名和属性值
			List<Attribute> attrs = e.attributes();
			for(Attribute a: attrs){
				//System.out.println(a.getName());
		        //System.out.println(a.getStringValue());
				//System.out.println(a.getValue());
			}
			//获取节点名和节点值
			Iterator it = e.elementIterator();
			while(it.hasNext()){
				Element e2 = (Element)it.next();
				System.out.println(e2.getName());//name
				System.out.println(e2.getStringValue());//oooo我的青春我做主
				System.out.println(e2.getText());//我的青春我做主
			}
			
			
		    
		}
     } catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static void Dom4j(){
		   SAXReader reader=new SAXReader();
		     try {
				Document document = reader.read(new File("src/res/book.xml"));
			    //获取根节点books
				Element rootElement = document.getRootElement();
				Iterator iterator = rootElement.elementIterator();
				//遍历迭代器
				while(iterator.hasNext()){
					//将object--->Element  book
					Element e = (Element)iterator.next();
					//如果已知属性名
					String value = e.attributeValue("id");
					//System.out.println("属性名值："+value);
					//获取属性名和属性值
					List<Attribute> attrs = e.attributes();
					for(Attribute a: attrs){
						//System.out.println(a.getName());
				        //System.out.println(a.getStringValue());
						//System.out.println(a.getValue());
					}
					//获取节点名和节点值
					Iterator it = e.elementIterator();
					while(it.hasNext()){
						Element e2 = (Element)it.next();
						/*System.out.println(e2.getName());//name
						System.out.println(e2.getStringValue());//oooo我的青春我做主
						System.out.println(e2.getText());//我的青春我做主
*/					}
					
					
				    
				}
		     } catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
