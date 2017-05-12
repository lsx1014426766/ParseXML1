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
     //����һ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
			DocumentBuilder db = dbf.newDocumentBuilder();
		    Document d = db.parse("dom.xml");
			NodeList bookList = d.getElementsByTagName("book");
		    for(int i=0;i<bookList.getLength();i++){
		    	//��ȡbook�ڵ�
		    	Node n = bookList.item(i);
		    	//book�����Ժ�����ֵ�Ļ�ȡ��������
		    	/*NamedNodeMap attrs = n.getAttributes();
		    	for(int j=0;j<attrs.getLength();j++){
		    		Node a = attrs.item(j);
		    		//������������ֵ
		    		System.out.println(a.getNodeName());
		    		System.out.println(a.getNodeValue());
		    	}*/
		    	//�����֪����Щ���Կ���������ȡ����ֵ
		    	Element e=(Element) bookList.item(i);
		    	System.out.println(e.getAttribute("id"));
		    	//��ȡ�ӽڵ��б�
		    	NodeList childNodes = n.getChildNodes();
		    	for(int k=0;k<childNodes.getLength();k++){
		    	
		    		Node childNode = childNodes.item(k);
		    		//����text���͵�node��element���͵�node
		    		//elelment���͵�node��Ŀհ׻���Ҳ����Ϊ��һ���ڵ㣬��text���͵�node
		    		//���������õ���Ϣ��ֻ��elementnode������<name><a>ooo</a>�ҵ��ഺ������</name>
		    		if(childNode.getNodeType()==Node.ELEMENT_NODE){
		    			System.out.print(childNode.getNodeName());//name
		    			System.out.print(childNode.getNodeValue());//null
		    			//Ҫ��ýڵ�����:
		    			System.out.println(childNode.getFirstChild().getNodeValue());//null
		    			//null,���name����û��a��ǩ���õ��ľ���"�ҵ��ഺ������"
		    		   //��Ϊelement�����ݾ�ֻ��nodeName��һ��������<a></a>,����ǩ�ڵ����ݿ����������ӽڵ�
		    		   //����һ��д����
		    			System.out.println(childNode.getTextContent());//ooo�ҵ��ഺ������
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
		 //����һ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    try {
			DocumentBuilder db = dbf.newDocumentBuilder();
		    Document d = db.parse("dom.xml");
			NodeList bookList = d.getElementsByTagName("book");
		    for(int i=0;i<bookList.getLength();i++){
		    	//��ȡbook�ڵ�
		    	Node n = bookList.item(i);
		    	//book�����Ժ�����ֵ�Ļ�ȡ��������
		    	/*NamedNodeMap attrs = n.getAttributes();
		    	for(int j=0;j<attrs.getLength();j++){
		    		Node a = attrs.item(j);
		    		//������������ֵ
		    		System.out.println(a.getNodeName());
		    		System.out.println(a.getNodeValue());
		    	}*/
		    	//�����֪����Щ���Կ���������ȡ����ֵ
		    	Element e=(Element) bookList.item(i);
		    	//System.out.println(e.getAttribute("id"));
		    	//��ȡ�ӽڵ��б�
		    	NodeList childNodes = n.getChildNodes();
		    	for(int k=0;k<childNodes.getLength();k++){
		    	
		    		Node childNode = childNodes.item(k);
		    		//����text���͵�node��element���͵�node
		    		//elelment���͵�node��Ŀհ׻���Ҳ����Ϊ��һ���ڵ㣬��text���͵�node
		    		//���������õ���Ϣ��ֻ��elementnode������<name><a>ooo</a>�ҵ��ഺ������</name>
		    		if(childNode.getNodeType()==Node.ELEMENT_NODE){
		    			//System.out.print(childNode.getNodeName());//name
		    			//System.out.print(childNode.getNodeValue());//null
		    			//Ҫ��ýڵ�����:
		    			//System.out.println(childNode.getFirstChild().getNodeValue());//null
		    			//null,���name����û��a��ǩ���õ��ľ���"�ҵ��ഺ������"
		    		   //��Ϊelement�����ݾ�ֻ��nodeName��һ��������<a></a>,����ǩ�ڵ����ݿ����������ӽڵ�
		    		   //����һ��д����
		    			//System.out.println(childNode.getTextContent());//ooo�ҵ��ഺ������
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
