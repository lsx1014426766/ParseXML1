package com.lsx.dom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.lsx.entity.Book;

public class JDOMTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
      //ע�������������zip�µ�jar��������ķ�Χ���˲����ÿ�ʶ���ڲ�
		SAXBuilder sb=new SAXBuilder();
		InputStream in =null;
		List<Book>books=new ArrayList<Book>();
		try {
			//�����������ļ�
			//����������
		    in= new FileInputStream("src/res/book.xml");
			//ע�����document��jdom2�µ�
		    //����һ��ֱ�������ļ�
		    //Document d = sb.build("src/res/book.xml");
		    //��������������
		  //  Document d = sb.build(in);
		    //ע��һ��in�����ܱ�2��������
		    //Ϊ�˷�ֹ���룬���˸ı�xml�����е�encoding���Ի�������������
		    InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		    Document d = sb.build(isr);
		    //��ȡ���ڵ�books
		    Element rootElement = d.getRootElement();
		    //System.out.println(rootElement);//[Element: <books/>]
		    //��ȡ�ӽڵ㼯��2��book
		    List<Element> children = rootElement.getChildren();
		   
		    Book book=null;
		    for(int i=0;i<children.size();i++){
		    	book=new Book();
		    	Element element = children.get(i);
		    	//System.out.println(element);//
		    	List<Attribute> attributes = element.getAttributes();
		    	//�������Ѿ�֪�����������Ļ�
		    	String value = element.getAttributeValue("id");
		    	//System.out.println("����ֵ��"+value);
		    	book.setId(value);
		    	//�������е�����
		    	for(Attribute a:attributes){
		    		//System.out.print(a.getName());//id  ������
		    		//System.out.println(a.getValue());//1  ����ֵ
		    	
		    	}
		    	//�������еĽڵ�
		    	List<Element> children2 = element.getChildren();
		    	for(Element e:children2){
		    		//System.out.println(e.getName());  //name�ڵ���
		    		//System.out.println(e.getText());  //�ҵ��ഺ������  ͬ���µ�����
		    		//System.out.println(e.getValue()); //oooo�ҵ��ഺ������  ��������
		    	 if(e.getName().equals("name")){
		    		 book.setName(e.getValue());
		    	 }else if(e.getName().equals("price")){
		    		 book.setPrice(e.getValue());
		    	 }else if(e.getName().equals("language")){
		    		 book.setLanguage(e.getValue());
		    	 }else if(e.getName().equals("author")){
		    		 book.setAuthor(e.getValue());
		    	 }
		    	 
		    	}
		    	books.add(book);
		    	book=null;
		    }
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Book b:books){
			System.out.println(b.getName());
            System.out.println(b.getAuthor());
            System.out.println(b.getId());
            System.out.println(b.getPrice());
            System.out.println(b.getLanguage());
		}

}
	public static void JDOM(){
		//ע�������������zip�µ�jar��������ķ�Χ���˲����ÿ�ʶ���ڲ�
				SAXBuilder sb=new SAXBuilder();
				InputStream in =null;
				List<Book>books=new ArrayList<Book>();
				try {
					//�����������ļ�
					//����������
				    in= new FileInputStream("src/res/book.xml");
					//ע�����document��jdom2�µ�
				    //����һ��ֱ�������ļ�
				    //Document d = sb.build("src/res/book.xml");
				    //��������������
				  //  Document d = sb.build(in);
				    //ע��һ��in�����ܱ�2��������
				    //Ϊ�˷�ֹ���룬���˸ı�xml�����е�encoding���Ի�������������
				    InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				    Document d = sb.build(isr);
				    //��ȡ���ڵ�books
				    Element rootElement = d.getRootElement();
				    //System.out.println(rootElement);//[Element: <books/>]
				    //��ȡ�ӽڵ㼯��2��book
				    List<Element> children = rootElement.getChildren();
				   
				    Book book=null;
				    for(int i=0;i<children.size();i++){
				    	book=new Book();
				    	Element element = children.get(i);
				    	//System.out.println(element);//
				    	List<Attribute> attributes = element.getAttributes();
				    	//�������Ѿ�֪�����������Ļ�
				    	String value = element.getAttributeValue("id");
				    	//System.out.println("����ֵ��"+value);
				    	book.setId(value);
				    	//�������е�����
				    	for(Attribute a:attributes){
				    		//System.out.print(a.getName());//id  ������
				    		//System.out.println(a.getValue());//1  ����ֵ
				    	
				    	}
				    	//�������еĽڵ�
				    	List<Element> children2 = element.getChildren();
				    	for(Element e:children2){
				    		//System.out.println(e.getName());  //name�ڵ���
				    		//System.out.println(e.getText());  //�ҵ��ഺ������  ͬ���µ�����
				    		//System.out.println(e.getValue()); //oooo�ҵ��ഺ������  ��������
				    	 if(e.getName().equals("name")){
				    		 book.setName(e.getValue());
				    	 }else if(e.getName().equals("price")){
				    		 book.setPrice(e.getValue());
				    	 }else if(e.getName().equals("language")){
				    		 book.setLanguage(e.getValue());
				    	 }else if(e.getName().equals("author")){
				    		 book.setAuthor(e.getValue());
				    	 }
				    	 
				    	}
				    	books.add(book);
				    	book=null;
				    }
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Book b:books){
					System.out.println(b.getName());
		            System.out.println(b.getAuthor());
		            System.out.println(b.getId());
		            System.out.println(b.getPrice());
		            System.out.println(b.getLanguage());
				}

	}
}