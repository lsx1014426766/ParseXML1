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
      //注意这里引入的是zip下的jar包，引入的范围大了不见得可识别到内部
		SAXBuilder sb=new SAXBuilder();
		InputStream in =null;
		List<Book>books=new ArrayList<Book>();
		try {
			//可引入流或文件
			//创建输入流
		    in= new FileInputStream("src/res/book.xml");
			//注意这个document是jdom2下的
		    //方法一：直接引入文件
		    //Document d = sb.build("src/res/book.xml");
		    //方法二：引入流
		  //  Document d = sb.build(in);
		    //注意一个in流不能被2个对象用
		    //为了防止乱码，除了改变xml声明中的encoding属性还可以这样做：
		    InputStreamReader isr = new InputStreamReader(in,"UTF-8");
		    Document d = sb.build(isr);
		    //获取根节点books
		    Element rootElement = d.getRootElement();
		    //System.out.println(rootElement);//[Element: <books/>]
		    //获取子节点集合2个book
		    List<Element> children = rootElement.getChildren();
		   
		    Book book=null;
		    for(int i=0;i<children.size();i++){
		    	book=new Book();
		    	Element element = children.get(i);
		    	//System.out.println(element);//
		    	List<Attribute> attributes = element.getAttributes();
		    	//如果如果已经知道了属性名的话
		    	String value = element.getAttributeValue("id");
		    	//System.out.println("属性值："+value);
		    	book.setId(value);
		    	//遍历所有的属性
		    	for(Attribute a:attributes){
		    		//System.out.print(a.getName());//id  属性名
		    		//System.out.println(a.getValue());//1  属性值
		    	
		    	}
		    	//遍历所有的节点
		    	List<Element> children2 = element.getChildren();
		    	for(Element e:children2){
		    		//System.out.println(e.getName());  //name节点名
		    		//System.out.println(e.getText());  //我的青春我做主  同级下的内容
		    		//System.out.println(e.getValue()); //oooo我的青春我做主  所有内容
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
		//注意这里引入的是zip下的jar包，引入的范围大了不见得可识别到内部
				SAXBuilder sb=new SAXBuilder();
				InputStream in =null;
				List<Book>books=new ArrayList<Book>();
				try {
					//可引入流或文件
					//创建输入流
				    in= new FileInputStream("src/res/book.xml");
					//注意这个document是jdom2下的
				    //方法一：直接引入文件
				    //Document d = sb.build("src/res/book.xml");
				    //方法二：引入流
				  //  Document d = sb.build(in);
				    //注意一个in流不能被2个对象用
				    //为了防止乱码，除了改变xml声明中的encoding属性还可以这样做：
				    InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				    Document d = sb.build(isr);
				    //获取根节点books
				    Element rootElement = d.getRootElement();
				    //System.out.println(rootElement);//[Element: <books/>]
				    //获取子节点集合2个book
				    List<Element> children = rootElement.getChildren();
				   
				    Book book=null;
				    for(int i=0;i<children.size();i++){
				    	book=new Book();
				    	Element element = children.get(i);
				    	//System.out.println(element);//
				    	List<Attribute> attributes = element.getAttributes();
				    	//如果如果已经知道了属性名的话
				    	String value = element.getAttributeValue("id");
				    	//System.out.println("属性值："+value);
				    	book.setId(value);
				    	//遍历所有的属性
				    	for(Attribute a:attributes){
				    		//System.out.print(a.getName());//id  属性名
				    		//System.out.println(a.getValue());//1  属性值
				    	
				    	}
				    	//遍历所有的节点
				    	List<Element> children2 = element.getChildren();
				    	for(Element e:children2){
				    		//System.out.println(e.getName());  //name节点名
				    		//System.out.println(e.getText());  //我的青春我做主  同级下的内容
				    		//System.out.println(e.getValue()); //oooo我的青春我做主  所有内容
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