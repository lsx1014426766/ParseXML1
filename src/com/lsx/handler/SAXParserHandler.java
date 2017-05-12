package com.lsx.handler;

import java.awt.List;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.lsx.entity.Book;

public class SAXParserHandler extends DefaultHandler {
	public int index=0;
	//��Ϊ����֮��ı�������������Ϊȫ�ֵ�
	String value=null;
	Book book=null;
	private ArrayList<Book> list=new ArrayList<Book>();
	
  /**
   * ������־������ʼ
   */
	@Override
public void startDocument() throws SAXException {
	// TODO Auto-generated method stub
	super.startDocument();
	System.out.println("������ʼ");
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
		//System.out.println("������ʼ��ǩ");
		if(qName.equals("book")){
			index++;
			book=new Book();
			//��֪book����������
			/*String value = attributes.getValue("id");
			System.out.println(value);*/
			//�����֪��������������
			for(int i=0;i<attributes.getLength();i++){
				System.out.print(attributes.getQName(i));//������
				System.out.println(attributes.getValue(i));//����ֵ
			}
			
		}else if(!qName.equals("book")&&!qName.equals("books")){
			//�����ڵ����ͽڵ�ֵ
			System.out.print("�ڵ�����"+qName);
		}
	}
  @Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		//System.out.println("����������ǩ");
		if(qName.equals("book")){
			System.out.println("��"+index+"�����������");

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
   * ������ʶ��������
   * 
   */
  @Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("��������");
	}
  @Override
public void characters(char[] ch, int start, int length) throws SAXException {
	// TODO Auto-generated method stub
	super.characters(ch, start, length);
	value = new String(ch, start, length);
	//���жϿո�ͻ��й��ɵĽڵ�
	if(!value.trim().equals("")){
		System.out.println(" �ڵ�ֵ��"+value);
	}
	
}
}
