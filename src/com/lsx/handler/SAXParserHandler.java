package com.lsx.handler;

import java.awt.List;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.lsx.entity.Book;

public class SAXParserHandler extends DefaultHandler {
	public int index=0;
	//因为方法之间的变量共享，所以设为全局的
	String value=null;
	Book book=null;
	private ArrayList<Book> list=new ArrayList<Book>();
	
  /**
   * 用来标志解析开始
   */
	@Override
public void startDocument() throws SAXException {
	// TODO Auto-generated method stub
	super.startDocument();
	System.out.println("解析开始");
}
  public ArrayList<Book> getList() {
	return list;
}
public void setList(ArrayList<Book> list) {
	this.list = list;
}
@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		//System.out.println("解析开始标签");
		if(qName.equals("book")){
			index++;
			book=new Book();
			//已知book下属性名称
			/*String value = attributes.getValue("id");
			System.out.println(value);*/
			//如果不知属性名及个数：
			for(int i=0;i<attributes.getLength();i++){
				System.out.print(attributes.getQName(i));//属性名
				System.out.println(attributes.getValue(i));//属性值
			}
			
		}else if(!qName.equals("book")&&!qName.equals("books")){
			//解析节点名和节点值
			System.out.print("节点名："+qName);
		}
	}
  @Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		//System.out.println("解析结束标签");
		if(qName.equals("book")){
			System.out.println("第"+index+"本书遍历结束");

			list.add(book);
			book=null;
		}else if(qName.equals("name")){
			book.setName(value);
		}else if(qName.equals("author")){
			book.setAuthor(value);
		}else if(qName.equals("price")){
			book.setPrice(value);
		}else if(qName.equals("language")){
			book.setLanguage(value);
		}else if(qName.equals("year")){
			book.setYear(value);
		}
		
	}
  /**
   * 用来标识解析结束
   * 
   */
  @Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("解析结束");
	}
  @Override
public void characters(char[] ch, int start, int length) throws SAXException {
	// TODO Auto-generated method stub
	super.characters(ch, start, length);
	value = new String(ch, start, length);
	//不判断空格和换行构成的节点
	if(!value.trim().equals("")){
		System.out.println(" 节点值："+value);
	}
	
}
}
