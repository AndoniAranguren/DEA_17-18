package eginkizuna2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrderedDoubleLinkedListTest<T> extends OrderedDoubleLinkedList<T> {

	protected OrderedDoubleLinkedList<T> listTest;
	protected T[] listAux;
	protected static int target;
	
	@SuppressWarnings("unchecked")
	public OrderedDoubleLinkedListTest() {		
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
		listTest= new OrderedDoubleLinkedList<T>();
		
		target= new java.util.Random().nextInt(listAux.length);
		for(int i=0; i<listAux.length;i++)
			listTest.add(listAux[i]);
	}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testAddAfter() {
		T aux = listTest.last();
		listTest.removeLast();
		org.junit.Assert.assertNotEquals(listTest.last(),aux);
		listTest.add(aux);
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
		java.util.Iterator<T> iterator= listTest.iterator();
		T aux = listTest.first();

		org.junit.Assert.assertTrue(listTest.contains(aux));
		while(iterator.hasNext())
			org.junit.Assert.assertTrue(aux.hashCode()<=iterator.next().hashCode());
		
		listTest.remove(aux);
		org.junit.Assert.assertFalse(listTest.contains(aux));
	}

	@Test
	public void testLast() {
		java.util.Iterator<T> iterator= listTest.iterator();
		T aux = listTest.last();

		org.junit.Assert.assertTrue(listTest.contains(aux));
		while(iterator.hasNext())
			org.junit.Assert.assertTrue(aux.hashCode()>=iterator.next().hashCode());
		
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
		listTest= new OrderedDoubleLinkedList<T>();
		org.junit.Assert.assertEquals(listTest.size(),0);
	}

	@Test
	public void testIterator() {
		java.util.Iterator<T> iterator= listTest.iterator();
		T auxCurrent,auxNext=null;
		
		if(iterator.hasNext())auxNext=iterator.next();
		while(iterator.hasNext()) {
			auxCurrent=auxNext;
			auxNext=iterator.next();
			org.junit.Assert.assertTrue(auxCurrent.hashCode()<=auxNext.hashCode());
		}
	}
}
