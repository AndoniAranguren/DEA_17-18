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
		
		Pertsona[] l= new Pertsona[size];
		String[] names= new String[] {"Jorge","Maria","Anabel","Mikel","John","Manuel","Pedro","Carmen"};
		
		for(int i=0; i<size; i++)
			l[i] = new Pertsona(names[new java.util.Random().nextInt(names.length)], ""+i);
		
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
		//Add null
			int size=listTest.size();
			
			System.out.println("\nIt should throw an error message (it's being managed):");
			listTest.addToFront(null);
			org.junit.Assert.assertEquals(size,listTest.size());
		
		//Lots of elements in the list
			T aux = listAux[target];
			org.junit.Assert.assertNotEquals(listTest.first(),aux);
			listTest.addToFront(aux);
			org.junit.Assert.assertEquals(listTest.first(),aux);
		
		//Empty list
			listTest=new UnorderedDoubleLinkedList<>();
			listTest.addToFront(aux);
			org.junit.Assert.assertTrue(listTest.contains(aux));
		
	}

	@Test
	public void testAddToRear() {
		//Add null
			int size=listTest.size();

			System.out.println("\nIt should throw an error message (it's being managed):");
			listTest.addToRear(null);
			org.junit.Assert.assertEquals(size,listTest.size());

		//Lots of elements in the list
			T aux = listAux[target];
			listTest.addToRear(aux);
			org.junit.Assert.assertEquals(listTest.last(),aux);
		
		//Empty list
			aux = listAux[target];
			listTest=new UnorderedDoubleLinkedList<>();
			listTest.addToRear(aux);
			org.junit.Assert.assertTrue(listTest.contains(aux));
		
	}

	@Test
	public void testAddAfter() {
		//Add null
			int size=listTest.size();
			
			System.out.println("\nIt should throw 3 error messages (they're being managed):");
			listTest.addAfter(null, null);
			listTest.addAfter(listTest.first(), null);
			listTest.addAfter(null, listTest.first());
			org.junit.Assert.assertEquals(size,listTest.size());

		//Lots of elements in the list
			T aux = listAux[target];
			listTest.addAfter(aux,listTest.last());
			org.junit.Assert.assertEquals(listTest.last(),aux);
		
		//Empty list
			listTest=new UnorderedDoubleLinkedList<>();
			listTest.addAfter(listAux[0],listAux[1]);
			org.junit.Assert.assertFalse(listTest.contains(listAux[1]));
		
		//Has 1 element and adding to the last one
			listTest.addToRear(listAux[0]);
			listTest.addAfter(listAux[1],listAux[0]);
			org.junit.Assert.assertTrue(listTest.contains(listAux[1]));
		
	}

	@Test
	public void testRemoveFirst() {
		//Lots of elements in the list
			T aux = listTest.first();
			org.junit.Assert.assertTrue(listTest.contains(aux));
			listTest.removeFirst();
			org.junit.Assert.assertFalse(listTest.contains(aux));	

		//Empty list
			listTest=new UnorderedDoubleLinkedList<>();
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
			listTest=new UnorderedDoubleLinkedList<>();
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
			listTest=new UnorderedDoubleLinkedList<>();
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
			listTest=new UnorderedDoubleLinkedList<>();
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
			listTest=new UnorderedDoubleLinkedList<>();
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
			listTest=new UnorderedDoubleLinkedList<>();
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
			listTest=new UnorderedDoubleLinkedList<>();
			org.junit.Assert.assertNull(listTest.find(aux));
	
	}

	@Test
	public void testIsEmpty() {
		//Lots of elements in the list
			org.junit.Assert.assertNotEquals(listTest.size(),0);
	
		//Empty list
			listTest= new UnorderedDoubleLinkedList<T>();
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
			listTest= new UnorderedDoubleLinkedList<T>();
			iterator= listTest.iterator();
			index=0;
			
			while(iterator.hasNext()) {
				org.junit.Assert.assertEquals(iterator.next(),listAux[index++]);
			}
	}
}
