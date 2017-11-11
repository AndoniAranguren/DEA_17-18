package eginkizuna2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("rawtypes")
public class DoubleLinkedListTest<T> extends DoubleLinkedList {
	
	protected DoubleLinkedList<T> listTest,original;
	protected T[] listAux;
	protected int target;

	public DoubleLinkedListTest(DoubleLinkedList<T> pListTest,T[] pListAux) {
		original=pListTest;
		listAux= pListAux;
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		target= new java.util.Random().nextInt(listAux.length);
		listTest=original;
	}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testRemoveFirst() {
		T aux = listTest.first();
		org.junit.Assert.assertTrue(listTest.contains(aux));
		listTest.removeFirst();
		org.junit.Assert.assertFalse(listTest.contains(aux));
		
	}

	@Test
	public void testRemoveLast() {
		T aux = listTest.last();
		org.junit.Assert.assertTrue(listTest.contains(aux));
		listTest.removeLast();
		org.junit.Assert.assertFalse(listTest.contains(aux));
	}

	@Test
	public void testRemove() {
		T aux = listAux[target];
		org.junit.Assert.assertTrue(listTest.contains(aux));
		listTest.remove(aux);
		org.junit.Assert.assertFalse(listTest.contains(aux));
	}

	@Test
	public void testFirst() {
		T aux = listAux[0];
		org.junit.Assert.assertEquals(listTest.first(),aux);
		org.junit.Assert.assertTrue(listTest.contains(aux));
		listTest.remove(aux);
		org.junit.Assert.assertFalse(listTest.contains(aux));
	}

	@Test
	public void testLast() {
		T aux = listAux[listAux.length];
		org.junit.Assert.assertEquals(listTest.last(),aux);
		org.junit.Assert.assertTrue(listTest.contains(aux));
		listTest.remove(aux);
		org.junit.Assert.assertFalse(listTest.contains(aux));
		
	}

	@Test
	public void testContains() {
		T aux = listAux[target];
		org.junit.Assert.assertTrue(listTest.contains(aux));
		listTest.remove(aux);
		org.junit.Assert.assertFalse(listTest.contains(aux));
	}

	@Test
	public void testFind() {
		T aux = listAux[target];
		org.junit.Assert.assertEquals(listTest.find(aux),aux);
		listTest.remove(aux);
		org.junit.Assert.assertNull(listTest.find(aux));
	}

	@Test
	public void testIsEmpty() {
		org.junit.Assert.assertTrue(listTest.size()==0);
	}

	@Test
	public void testIterator() {
		java.util.Iterator<T> iterator= listTest.iterator();
		int index=0;
		
		while(iterator.hasNext()) {
			org.junit.Assert.assertEquals(iterator.next(),listAux[index++]);
		}
	}
}
