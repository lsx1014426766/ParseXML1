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
	  //���Զ�ȡxml�ļ���-----��xml�ַ���
	   @Test  
	    public void test5()throws Exception{  
	        //����SAXReader����  
	        SAXReader reader = new SAXReader();  
	        //��ȡ�ļ� ת����Document  
	        Document document = reader.read(new File("src/res/book.xml"));  
	        //documentת��ΪString�ַ���  
	        String documentStr = document.asXML();  
	        System.out.println("document �ַ�����" + documentStr);  
	        //��ȡ���ڵ�  
	        Element root = document.getRootElement();  
	        //���ڵ�ת��ΪString�ַ���  
	        String rootStr = root.asXML();  
	        System.out.println("root �ַ�����" + rootStr);  
	        //��ȡ���е�һ��book�ڵ�  
	        Element student1Node = root.element("book");  
	        //book�ڵ�ת��ΪString�ַ���  
	        String student1Str = student1Node.asXML();  
	        System.out.println("student1 �ַ�����" + student1Str);  
	    }
	   //��ȡ��ȡxml�ַ���
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
			}//�y�c
			System.out.println("document"+doc.asXML());
			//���ﱨ��java.lang.NoClassDefFoundError: org/jaxen/JaxenException
			//������Ϊ��ֻ�����˺���jar������������jar��
			Node n = doc.selectSingleNode("KV/JPG-320X320-NODELIST");
			String s = n.getStringValue();
			System.out.println("�ڵ�ֵ��"+s);

	 //���ýڵ�ֵ
	 //
		doc.selectSingleNode("KV/JPG-320X320-NODELIST").setText("ammmmm");
			Node n1 = doc.selectSingleNode("KV/JPG-320X320-NODELIST");
			System.out.println(n1.getStringValue());
	// ��������ֵ
		Element rootE = doc.getRootElement();
	     //�����������Խڵ�,û�еĻ�����Ӳ���ֵ
		rootE.setAttributeValue("JPG-320X320-NODELIST","wwww");
		//�Ƴ����Խڵ�
		rootE.remove(rootE.attribute("JPG-320X320-NODELIST"));
	
			doc.setRootElement(rootE);
			System.out.println(doc.asXML());
            System.out.println("����ֵ��"+doc.selectSingleNode("KV/JPG-320X320-NODELIST").getText());

		}


	   
	public static void main(String[] args) {
     SAXReader reader=new SAXReader();
     try {
		Document document = reader.read(new File("src/res/book.xml"));
	    //��ȡ���ڵ�books
		Element rootElement = document.getRootElement();
		Iterator iterator = rootElement.elementIterator();
		//����������
		while(iterator.hasNext()){
			//��object--->Element  book
			Element e = (Element)iterator.next();
			//�����֪������
			String value = e.attributeValue("id");
			System.out.println("������ֵ��"+value);
			//��ȡ������������ֵ
			List<Attribute> attrs = e.attributes();
			for(Attribute a: attrs){
				//System.out.println(a.getName());
		        //System.out.println(a.getStringValue());
				//System.out.println(a.getValue());
			}
			//��ȡ�ڵ����ͽڵ�ֵ
			Iterator it = e.elementIterator();
			while(it.hasNext()){
				Element e2 = (Element)it.next();
				System.out.println(e2.getName());//name
				System.out.println(e2.getStringValue());//oooo�ҵ��ഺ������
				System.out.println(e2.getText());//�ҵ��ഺ������
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
			    //��ȡ���ڵ�books
				Element rootElement = document.getRootElement();
				Iterator iterator = rootElement.elementIterator();
				//����������
				while(iterator.hasNext()){
					//��object--->Element  book
					Element e = (Element)iterator.next();
					//�����֪������
					String value = e.attributeValue("id");
					//System.out.println("������ֵ��"+value);
					//��ȡ������������ֵ
					List<Attribute> attrs = e.attributes();
					for(Attribute a: attrs){
						//System.out.println(a.getName());
				        //System.out.println(a.getStringValue());
						//System.out.println(a.getValue());
					}
					//��ȡ�ڵ����ͽڵ�ֵ
					Iterator it = e.elementIterator();
					while(it.hasNext()){
						Element e2 = (Element)it.next();
						/*System.out.println(e2.getName());//name
						System.out.println(e2.getStringValue());//oooo�ҵ��ഺ������
						System.out.println(e2.getText());//�ҵ��ഺ������
*/					}
					
					
				    
				}
		     } catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
