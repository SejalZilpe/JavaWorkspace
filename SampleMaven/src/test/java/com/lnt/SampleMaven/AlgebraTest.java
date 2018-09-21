package com.lnt.SampleMaven;

import junit.framework.TestCase;

public class AlgebraTest extends TestCase {
	
		Algebra al = new Algebra();
	
	Algebra a =new Algebra();
	
	public void testAdd()
	{
		int add = al.add(10,5);
		assertEquals(15, a.add(5, 10));
	}
	public void testSub()
	{
		int sub = al.sub(10,5);
		assertEquals(5, a.sub(10, 5));
	}
	public void testMul()
	{
		int mul = al.mul(10,5);
		assertEquals(50, a.mul(5, 10));
	}

}
