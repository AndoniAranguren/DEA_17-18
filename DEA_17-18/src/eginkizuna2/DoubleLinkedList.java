package eginkizuna2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

//	 Atributuak
	protected Node<T> first; // lehenengoaren erreferentzia
	protected String deskr;  // deskribapena
	protected int count;

	public DoubleLinkedList() {
		first = null;
		deskr = "";
		count = 0;
	}
	
	public void setDeskr(String ize) {
	  deskr = ize;
	}

	public String getDeskr() {
	  return deskr;
	}
	
	/**
	This method removes the first element of the list
	@return Returns the first element from the list
	@throws Exception When the list is empty, it returns null
	@Cost_Function The cost is O(1)
	*/
	public T removeFirst() {
		if(isEmpty()){
			try {
				throw new Exception("The list is empty, nothing was removed");
			} catch (Exception e) {
//				System.err.println(e.getMessage());
				return null;
			}
		}else {
			T pElement;
			if (first.next.equals(first)){ //listan pElemententu bakarra
				pElement=first.data;
				first=null;
				count--;
			}
			else{ //Puntero batek lista borobila izatean berari apuntatzen da .next eta .prev - ekin
				pElement=first.data;
				first.prev.next=first.next;
				first.next.prev=first.prev;
				first=first.next;
				count--;
			}
			return pElement;
		}
	}
	
	/**
	This method removes the last element of the list
	@return Returns the last element from the list
	@throws Exception When the list is empty, it returns null
	@Cost_Function The cost is O(1)
	*/
	public T removeLast() {
		if(isEmpty()){
			try {
				throw new Exception("The list is empty, nothing was removed");
			} catch (Exception e) {
//				System.err.println(e.getMessage());
				return null;
			}
		}else {
			T pElement;
			Node<T> current=null;
			Node<T> last=first.prev;
			if (first.next.equals(first)){ //listan pElemententu bakarra
				pElement=first.data; 
				first=null;
				count--;
			}
			else{
				pElement=last.data;
				current=last.prev;
				current.next=first; 
				first.prev=current;
				count--;
			}
			return pElement;
		}
	}

	/**
	This method removes the pElement from the list
	@param pElement is the T value it's being removed
	@return Returns pElement from the list or null if it isn't there
	@throws Exception When the list is empty, it returns null
	@Cost_Function The cost is O(n)
	*/
	public T remove(T pElement) { 
		if(isEmpty()){
			try {
				throw new Exception("The list is empty, nothing was removed");
			} catch (Exception e) {
//				System.err.println(e.getMessage());
				return null;
			}
		}else {
			Node<T> current=first;
			int kont=0;
			boolean aurkitua=false;
			if (first!=null){
				while (kont<=count && aurkitua==false){
					if (current.data.hashCode()==pElement.hashCode()){
						if (current.equals(first)){ //Lehenengoa
							removeFirst();
						}
						else if (current.next.equals(first)){ //listako azkenengo pElemententua
							removeLast();
						}else {
							current.prev.next=current.next;
							current.next.prev=current.prev; 
							count--;
						}
						aurkitua=true;
					}else {
						current=current.next;
						kont++;
						
					}
				}
			}
			return (aurkitua? pElement : null);
		}
	}

	/**
	This method return the first element of the list
	@return Returns the first element from the list
	@Cost_Function The cost is O(1)
	*/
	public T first() {
	// listako lehen pElemententua ematen du
	      if (isEmpty())
	          return null;
	      else return first.data;
	}
	
	/**
	This method return the last element of the list
	@return Returns the last element from the list
	@Cost_Function The cost is O(1)
	*/
	public T last() {
	// listako azken pElemententua ematen du
	      if (isEmpty())
	          return null;
	      else return first.prev.data;
	}
	
	/**
	This method says if pElement is in the list or not
	@param pElement is the T value that is being searched
	@return Returns true if pElement in the list or false if it isn't
	@throws Exception When the list is empty, it returns false
	@Cost_Function The cost is O(n)
	*/
	public boolean contains(T pElement) {
		if(isEmpty()){
			try {
				throw new Exception("The list is empty, false will be returned");
			} catch (Exception e) {
//				System.err.println(e.getMessage());
				return false;
			}
		}else {
			Node<T> current=first;
			Node<T> last=first.prev;
			int kont=0;
			boolean aurkituta=false;
			if(pElement!=null){
			    while (kont<count && aurkituta==false){
			    	 if (last.data.equals(pElement)){ //azkenengo pElemententua da
			 			aurkituta=true;
			    	 }
			    	 else if (current.data.equals(pElement)){
			    		 aurkituta=true;
			    	 }
			    	 current=current.next;
			    	 kont++;
			     }
			   }
			return aurkituta;
		}
	}

	/**
	This method finds pElement in the list
	@param pElement is the T value that is being searched
	@return Returns pElement if pElement is in the list or null if it isn't
	@throws Exception When the list is empty, it returns null
	@Cost_Function The cost is O(n)
	*/
	public T find(T pElement) {
		if(isEmpty()){
			try {
				throw new Exception("The list is empty, null will be returned");
			} catch (Exception e) {
//				System.err.println(e.getMessage());
				return null;
			}
		}else
			return (contains(pElement)? pElement : null);
	}
	
	/**
	This method says if the list is empty
	@return Returns true if it's empty, false if not
	@Cost_Function The cost is O(1)
	*/
	public boolean isEmpty() 
	{ return first == null;};
	
	/**
	This method returns the size of the list
	@return Returns an int with the size
	@Cost_Function The cost is O(1)
	*/
	public int size() 
	{ return count;}
	
	/**
	 *  Return an iterator to the stack that iterates through the items .  
	 */ 
	public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	private class ListIterator implements Iterator<T> { 
		   private int i=0;
		   Node<T> current=first;
		   T pElement;
		   
		   public boolean hasNext(){
			   if (isEmpty() || i>=count) return false;
			   else{
				   return true;
			   }
		   }
		   
		   public T next(){
			   if (!hasNext()){
				   throw new NoSuchElementException();
			   }
			   else{
				   if(current!=null) {
					   pElement=current.data;
					   current=current.next;
					   i++;
				   }
				   i++;
			   }
			   return pElement;
		   }
		   
		   public void remove(){
			   throw new UnsupportedOperationException("an iterator, doesn't implement remove() since it's optional");
		   }
	   } // private class
	
	/**
	This method gives information about the string
	@return Returns a string with the information of the list
	@Cost_Function The cost is O(n)
	*/	
	@Override
	public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			try{
				while (it.hasNext()) {
					T element = it.next();
					result = result + "[" + element.toString() + "]  ";
				}	
			}
			catch(Exception e){
				System.err.println("Errorea eman da toString metodoan.");;
			}
			return "SimpleLinkedList " + result;
		}

}
