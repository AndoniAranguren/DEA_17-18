package eginkizuna2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnorderedDoubleLinkedListTest<T> extends UnorderedDoubleLinkedList<T> {

	protected UnorderedDoubleLinkedList<T> listTest;
	protected T[] listAux;
	protected static int target;
	
	@SuppressWarnings("unchecked")
	public UnorderedDoubleLinkedListTest() {		
		int size= 25;
		String[] l= new String[size];
		for(int i=0; i<size; i++)
			l[i]=""+new java.util.Random().nextInt();
		
		listAux= (T[]) l;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		listTest= new UnorderedDoubleLinkedList<T>();
		
		target= new java.util.Random().nextInt(listAux.length);
		for(int i=0; i<listAux.length;i++)
			listTest.addToRear(listAux[i]);
	}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testAddToFront() {
		T aux = listAux[target];
		org.junit.Assert.assertNotEquals(listTest.first(),aux);
		listTest.addToFront(aux);
		org.junit.Assert.assertEquals(listTest.first(),aux);
	}

	@Test
	public void testAddToRear() {
		T aux = listAux[target];
		org.junit.Assert.assertNotEquals(listTest.last(),aux);
		listTest.addToRear(aux);
		org.junit.Assert.assertEquals(listTest.last(),aux);
	}

	@Test
	public void testAddAfter() {
		T aux = listAux[target];
		org.junit.Assert.assertNotEquals(listTest.last(),aux);
		listTest.addAfter(aux,listTest.last());
		org.junit.Assert.assertEquals(listTest.last(),aux);
	}

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
		T aux = listAux[listAux.length-1];
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
		org.junit.Assert.assertNotEquals(listTest.size(),0);
		listTest= new UnorderedDoubleLinkedList<T>();
		org.junit.Assert.assertEquals(listTest.size(),0);
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
