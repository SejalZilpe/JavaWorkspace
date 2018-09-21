package com.lnt.MavenTask;

import junit.framework.TestCase;

public class TestForApp extends TestCase {
	
	App word =new App();
	
	public void teststring()
	{
		assertEquals(8, word.getLength("thisisus"));
	}

}
