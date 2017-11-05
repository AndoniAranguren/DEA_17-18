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
	public void testAdd() {
		//Add null
			int size=listTest.size();
			
			System.out.println("\nIt should throw an error message (it's being managed):");
			listTest.add(null);
			org.junit.Assert.assertEquals(size,listTest.size());
		
		//Lots of elements in the list
			T aux = listAux[target];
			org.junit.Assert.assertNotEquals(listTest.first(),aux);
			listTest.add(aux);
			org.junit.Assert.assertEquals(listTest.first(),aux);
		
		//Empty list
			listTest=new OrderedDoubleLinkedList<>();
			listTest.add(aux);
			org.junit.Assert.assertTrue(listTest.contains(aux));
		
	}
	@Test
	public void testRemoveFirst() {
		//Lots of elements in the list
			T aux = listTest.first();
			org.junit.Assert.assertTrue(listTest.contains(aux));
			listTest.removeFirst();
			org.junit.Assert.assertFalse(listTest.contains(aux));	

		//Empty list
			listTest=new OrderedDoubleLinkedList<>();
			listTest.removeFirst();
			org.junit.Assert.assertEquals(listTest.size(),0);
			org.junit.Assert.assertFalse(listTest.contains(aux));
		
	}

	@Test
	public void testRemoveLast() {
		//Lots of elements in the list
			T aux = listTest.last();
			org.junit.Assert.assertTrue(listTest.contains(aux));
			listTest.removeLast();
			org.junit.Assert.assertFalse(listTest.contains(aux));	

		//Empty list
			listTest=new OrderedDoubleLinkedList<>();
			listTest.removeLast();
			org.junit.Assert.assertEquals(listTest.size(),0);
			org.junit.Assert.assertFalse(listTest.contains(aux));	
	}

	@Test
	public void testRemove() {
		//Lots of elements in the list
			T aux = listAux[target];
			org.junit.Assert.assertTrue(listTest.contains(aux));
			listTest.remove(aux);
			org.junit.Assert.assertFalse(listTest.contains(aux));	
	
		//Empty list
			listTest=new OrderedDoubleLinkedList<>();
			listTest.remove(aux);
			org.junit.Assert.assertEquals(listTest.size(),0);
			org.junit.Assert.assertFalse(listTest.contains(aux));	

	}

	@Test
	public void testFirst() {
		//Lots of elements in the list
			T aux = listAux[0];
			org.junit.Assert.assertEquals(listTest.first(),aux);
			org.junit.Assert.assertTrue(listTest.contains(aux));
			listTest.remove(aux);
			org.junit.Assert.assertFalse(listTest.contains(aux));

		//Empty list
			listTest=new OrderedDoubleLinkedList<>();
			org.junit.Assert.assertNull(listTest.first());
	}

	@Test
	public void testLast() {
		//Lots of elements in the list
			T aux = listAux[listAux.length-1];
			org.junit.Assert.assertEquals(listTest.last(),aux);
			org.junit.Assert.assertTrue(listTest.contains(aux));
			listTest.remove(aux);
			org.junit.Assert.assertFalse(listTest.contains(aux));
	
		//Empty list
			listTest=new OrderedDoubleLinkedList<>();
			org.junit.Assert.assertNull(listTest.last());
	}

	@Test
	public void testContains() {
		//Lots of elements in the list
			T aux = listAux[target];
			org.junit.Assert.assertTrue(listTest.contains(aux));
			listTest.remove(aux);
			org.junit.Assert.assertFalse(listTest.contains(aux));
	
		//Empty list
			listTest=new OrderedDoubleLinkedList<>();
			org.junit.Assert.assertFalse(listTest.contains(aux));
	
	}

	@Test
	public void testFind() {
		//Lots of elements in the list
			T aux = listAux[target];
			org.junit.Assert.assertEquals(listTest.find(aux),aux);
			listTest.remove(aux);
			org.junit.Assert.assertNull(listTest.find(aux));
	
		//Empty list
			listTest=new OrderedDoubleLinkedList<>();
			org.junit.Assert.assertNull(listTest.find(aux));
	
	}

	@Test
	public void testIsEmpty() {
		//Lots of elements in the list
			org.junit.Assert.assertNotEquals(listTest.size(),0);
	
		//Empty list
			listTest= new OrderedDoubleLinkedList<T>();
			org.junit.Assert.assertEquals(listTest.size(),0);
	}

	@Test
	public void testIterator() {
		//Lots of elements in the list
			java.util.Iterator<T> iterator= listTest.iterator();
			int index=0;
			
			while(iterator.hasNext()) {
				org.junit.Assert.assertEquals(iterator.next(),listAux[index++]);
			}
	
		//Empty list
			listTest= new OrderedDoubleLinkedList<T>();
			iterator= listTest.iterator();
			index=0;
			
			while(iterator.hasNext()) {
				org.junit.Assert.assertEquals(iterator.next(),listAux[index++]);
			}
	}
}
