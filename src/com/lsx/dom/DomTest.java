package com.lsx.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
     //创建一个
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
			DocumentBuilder db = dbf.newDocumentBuilder();
		    Document d = db.parse("dom.xml");
			NodeList bookList = d.getElementsByTagName("book");
		    for(int i=0;i<bookList.getLength();i++){
		    	//获取book节点
		    	Node n = bookList.item(i);
		    	//book的属性和属性值的获取（遍历）
		    	/*NamedNodeMap attrs = n.getAttributes();
		    	for(int j=0;j<attrs.getLength();j++){
		    		Node a = attrs.item(j);
		    		//属性名，属性值
		    		System.out.println(a.getNodeName());
		    		System.out.println(a.getNodeValue());
		    	}*/
		    	//如果已知有哪些属性可以这样获取属性值
		    	Element e=(Element) bookList.item(i);
		    	System.out.println(e.getAttribute("id"));
		    	//获取子节点列表
		    	NodeList childNodes = n.getChildNodes();
		    	for(int k=0;k<childNodes.getLength();k++){
		    	
		    		Node childNode = childNodes.item(k);
		    		//区分text类型的node和element类型的node
		    		//elelment类型的node间的空白换行也别人为是一个节点，即text类型的node
		    		//对我们有用的信息就只是elementnode的内容<name><a>ooo</a>我的青春我做主</name>
		    		if(childNode.getNodeType()==Node.ELEMENT_NODE){
		    			System.out.print(childNode.getNodeName());//name
		    			System.out.print(childNode.getNodeValue());//null
		    			//要获得节点内容:
		    			System.out.println(childNode.getFirstChild().getNodeValue());//null
		    			//null,如果name下面没有a标签，得到的就是"我的青春我做主"
		    		   //因为element的内容就只是nodeName这一部分属于<a></a>,而标签内的内容看做是它的子节点
		    		   //另外一种写法：
		    			System.out.println(childNode.getTextContent());//ooo我的青春我做主
		    		}
		    		
		    	
		    	}
		    }
			
	    } catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Dom(){
		 //创建一个
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
			DocumentBuilder db = dbf.newDocumentBuilder();
		    Document d = db.parse("dom.xml");
			NodeList bookList = d.getElementsByTagName("book");
		    for(int i=0;i<bookList.getLength();i++){
		    	//获取book节点
		    	Node n = bookList.item(i);
		    	//book的属性和属性值的获取（遍历）
		    	/*NamedNodeMap attrs = n.getAttributes();
		    	for(int j=0;j<attrs.getLength();j++){
		    		Node a = attrs.item(j);
		    		//属性名，属性值
		    		System.out.println(a.getNodeName());
		    		System.out.println(a.getNodeValue());
		    	}*/
		    	//如果已知有哪些属性可以这样获取属性值
		    	Element e=(Element) bookList.item(i);
		    	//System.out.println(e.getAttribute("id"));
		    	//获取子节点列表
		    	NodeList childNodes = n.getChildNodes();
		    	for(int k=0;k<childNodes.getLength();k++){
		    	
		    		Node childNode = childNodes.item(k);
		    		//区分text类型的node和element类型的node
		    		//elelment类型的node间的空白换行也别人为是一个节点，即text类型的node
		    		//对我们有用的信息就只是elementnode的内容<name><a>ooo</a>我的青春我做主</name>
		    		if(childNode.getNodeType()==Node.ELEMENT_NODE){
		    			//System.out.print(childNode.getNodeName());//name
		    			//System.out.print(childNode.getNodeValue());//null
		    			//要获得节点内容:
		    			//System.out.println(childNode.getFirstChild().getNodeValue());//null
		    			//null,如果name下面没有a标签，得到的就是"我的青春我做主"
		    		   //因为element的内容就只是nodeName这一部分属于<a></a>,而标签内的内容看做是它的子节点
		    		   //另外一种写法：
		    			//System.out.println(childNode.getTextContent());//ooo我的青春我做主
		    		}
		    		
		    	
		    	}
		    }
			
	    } catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
