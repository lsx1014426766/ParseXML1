package com.lsx.dom;

import org.junit.Test;

public class ParseTest{
	@Test
	public void testPerformance(){
		//≤‚ ‘dom102
		long start = System.currentTimeMillis();
		DomTest.Dom();
		System.out.println("dom"+(System.currentTimeMillis()-start));
		//≤‚ ‘sax28
		start=System.currentTimeMillis();
		SAXTest.SAX();
		System.out.println("sax:"+(System.currentTimeMillis()-start));
		//≤‚ ‘jdom
		start = System.currentTimeMillis();
		JDOMTest.JDOM();
		System.out.println("jdom:"+(System.currentTimeMillis()-start));
		//≤‚ ‘dom4j
		start=System.currentTimeMillis();
		Dom4JTest.Dom4j();
		System.out.println("dom4j:"+(System.currentTimeMillis()-start));
	}
}