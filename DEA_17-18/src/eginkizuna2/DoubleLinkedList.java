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

	public T removeFirst() {
	// listako lehen elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		T elem=null;
		if (first.next.equals(first)){ //listan elementu bakarra
			elem=first.data;
			first=null;
			count--;
		}
		else{ //Puntero batek lista borobila izatean berari apuntatzen da .next eta .prev - ekin
			elem=first.data;
			first.prev.next=first.next;
			first.next.prev=first.prev;
			first=first.next;
			count--;
		}
		return elem;
	} // O(1)

	public T removeLast() {
	// listako azken elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
		T elem=null;
		Node<T> current=null;
		Node<T> last=first.prev;
		if (first.next.equals(first)){ //listan elementu bakarra
			elem=first.data; 
			first=null;
			count--;
		}
		else{
			elem=last.data;
			current=last.prev;
			current.next=first; 
			first.prev=current;
			count--;
		}
		return elem;
    }	// O(1)


	public T remove(T elem) { 	
	// Aurrebaldintza: zerrenda ez da hutsa
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
	//  bueltatuko du (null ez baldin badago)
		Node<T> current=first,aux;
		int kont=0;
		boolean aurkitua=false;
		if (first!=null){
			while (kont<=count && aurkitua==false){
				if (current.data.hashCode()==elem.hashCode()){
					if (current.equals(first)){ //Lehenengoa
						removeFirst();
					}
					else if (current.next.equals(first)){ //listako azkenengo elementua
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
		return (aurkitua? elem : null);
	} 	// O(n)

	//Si tengo un current en T remove y esta apuntando al nodo numero 3(ejemplo) 
	// y llamo a un metodo que tiene current en null, luego al volver al programa principal 
	//el current vuelve a estar donde antes(nodo 3) o pasa a estar null?
	
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
		Node<T> current=first;
		if (first!=null){
			Node<T> last=first.prev;
			int kont=0;
			boolean aurkituta=false;
			if (isEmpty()){
				return false;
			}
			else{
			     while (kont<count && aurkituta==false){
			    	 if (last.data.equals(elem)){ //azkenengo elementua da
			 			aurkituta=true;
			    	 }
			    	 else if (current.data.equals(elem)){
			    		 aurkituta=true;
			    	 }
			    	 current=current.next;
			    	 kont++;
			     }
			   }
			return aurkituta;
		}
		else return false;
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
		   private int i=0;
		   Node<T> current=first;
		   T elem;
		   
		   public boolean hasNext(){
			   if (isEmpty() || i==count) return false;
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
					   elem=current.data;
					   current=current.next;
					   i++;
				   }
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
			try{
				while (it.hasNext()) {
					T elem = it.next();
					result = result + "[" + elem.toString() + "] \n";
				}	
			}
			catch(Exception e){
				System.out.println("Errorea eman da toString metodoan.");;
			}
			return "SimpleLinkedList " + result + "]";
		}

}
