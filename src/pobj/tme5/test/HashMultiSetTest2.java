package pobj.tme5.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import org.junit.After;

import pobj.tme5.HashMultiSet;
import pobj.tme5.MultiSet;

public class HashMultiSetTest2 {
private MultiSet<String> m;
	
	@Before
	public void before() {
		m = new HashMultiSet<>();
		m.add("a",3);
		m.add("b");
		m.add("c",2);
	}
	/* test pour remove, clear, size
	 * 
	 */
	@Test
	public void testRemove(){
		m.remove("b");
		assertEquals(0,m.count("b"));
		m.remove("c",2);
		assertEquals(0,m.count("c"));
		m.remove("a",2);
		assertEquals(1,m.count("a"));
		
	}
	
	@Test
	public void testClear() {
		m.clear();
		assertEquals(0,m.size());
	}
	
	@Test
	public void testSize() {
		assertEquals(6,m.size());
		m.add("a");
		assertEquals(7,m.size());
		m.remove("a",4);
		assertEquals(0,m.size());
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testRemove2() {
		m.add("a");
		m.remove("a",-1);
	}
	
	@Test
	
	public void testToString() {
		assertEquals("[a:3; b:1; c:2]",m.toString());
	}
	
	@Test
	public void testComplex() {
		m.add("d",4);
		m.add("lettre",10);
		m.add("chiffre",5);
		m.add("nombre",1);
		m.add("a",3);
		
		assertEquals(4,m.count("d"));
		assertEquals(6,m.count("a"));
		assertEquals(10,m.count("lettre"));
		assertEquals(29,m.size());
		
		m.remove("lettre");
		m.remove("d",4);
		m.remove("nombre",1);
		
		assertEquals(9,m.count("lettre"));
		assertEquals(0,m.count("d"));
		assertEquals(23,m.size());
		assertEquals("[a:6; b:1; c:2; lettre:9; chiffre:5]",m.toString());
		
		
	}

	@Test
	public void testCasParticulier() {
		try{
			m.add("d",0);
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		
		try {
		m.remove("a",0);
		}
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		
		m.add("d",15);
		m.remove("d",15);
		assertEquals("[a:3; b:1; c:2]",m.toString());
		assertEquals(0,m.count("d"));
	}
}
