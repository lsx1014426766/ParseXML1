package com.lsx.dom;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.lsx.entity.Book;
import com.lsx.handler.SAXParserHandler;

public class SAXTest {

	public static void main(String[] args) {
     SAXParserFactory spf = SAXParserFactory.newInstance();
     try {
		SAXParser parser = spf.newSAXParser();
		SAXParserHandler handler=new SAXParserHandler();
			parser.parse("dom.xml", handler);
			ArrayList<Book> list = handler.getList();
			System.out.println(list.size());
			System.out.println(list.get(0).getAuthor());
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	}
	public static void SAX(){
	    SAXParserFactory spf = SAXParserFactory.newInstance();
	     try {
			SAXParser parser = spf.newSAXParser();
			SAXParserHandler handler=new SAXParserHandler();
				parser.parse("dom.xml", handler);
				ArrayList<Book> list = handler.getList();
				/*System.out.println(list.size());
				System.out.println(list.get(0).getAuthor());*/
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
