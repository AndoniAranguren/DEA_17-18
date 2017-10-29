package eginkizuna2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributuak
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

	public T removeFirst() {
	// listako lehen elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		T elem=null;
		Node<T> current=null;
		Node<T> last=first.prev;
		if (first.next==first){ //listan elementu bakarra
			elem=first.data;
			first=null;
		}
		else{ 				//Puntero batek lista borobila izatean berari apunta dakioke .next eta .prev - ekin?
			elem=first.data;
			current=first.next;
			last.next=current; 
			current.prev=last;
		}
		return elem;
	} // O(1)

	public T removeLast() {
	// listako azken elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		
		//CASO DE 2 ELEMENTOS??
		T elem=null;
		Node<T> current=null;
		Node<T> last=first.prev;
		if (first.next==first){ //listan elementu bakarra
			elem=first.data; 
			first=null;
		}
		else{
			elem=last.data;
			current=last.prev;
			current.next=first; 
			first.prev=current;
		}
		return elem;
    }	// O(1)


	public T remove(T elem) { 	
	// Aurrebaldintza: zerrenda ez da hutsa
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
	//  bueltatuko du (null ez baldin badago)
		
		Node<T> current=null;
		Node<T> aux=null;
		Node<T> last=first.prev;
		int kont=0;
		boolean agerpen=false;
		while (kont!=count && agerpen==false){
			if (current.data==elem){
				if (current==first){
					removeFirst();
					agerpen=true;
				}
				else if (current.next==first){ //listako azkenengo elementua
					current=current.prev;
					current.next=first;
					first.prev=current;
					agerpen=true;
				} //listako beste elementuak
				aux=aux.prev;
				aux.next=current.next;
				current=current.next; 
				current.prev=aux;
				agerpen=true;
			}
			current=current.next;
			aux=aux.next;
			kont++;
		}
		return (agerpen? elem : null);
	} 	// O(n)

	public T first() {
	// listako lehen elementua ematen du
	      if (isEmpty())
	          return null;
	      else return first.data;
	}

	public T last() {
	// listako azken elementua ematen du
	      if (isEmpty())
	          return null;
	      else return first.prev.data;
	}

	public boolean contains(T elem) {
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		Node<T> current=null;
		Node<T> last=first.prev;
		int kont=0;
		boolean aurkituta=false;
		if (isEmpty()){
			return false;
		}
		else{
		     while (kont!=count && aurkituta==false){
		    	 if (last.data==elem){ //azkenengo elementua da
		 			aurkituta=true;
		    	 }
		    	 else if (current.data==elem){
		    		 aurkituta=true;
		    	 }
		    	 current=current.next;
		    	 kont++;
		     }
		   }
		return aurkituta;
	}	//O(n)

	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela
		return (contains(elem)? elem : null);
	} 	//O(n)

	public boolean isEmpty() 
	{ return first == null;};
	
	public int size() 
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 
		   Node<T> current=null;
		   T elem;
		   
		   public boolean hasNext(){
			   return (current.next!=first);
		   }
		   
		   public T next(){
			   if (!hasNext()){
				   throw new NoSuchElementException();
			   }
			   else{
				   elem=current.data;
				   current=current.next;
			   }
			   return elem;
		   }
		   
		   public void remove(){
			   throw new UnsupportedOperationException("an iterator, doesn't implement remove() since it's optional");
		   }
	   } // private class
		
		
		public void adabegiakInprimatu() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}

}
