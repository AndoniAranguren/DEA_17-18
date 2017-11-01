package eginkizuna2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	private Node<T> first; // lehenengoaren erreferentzia
	private String deskr;  // deskribapena
	private int count;
	
	
	public void addToFront(T elem) {
	// hasieran gehitu
		Node<T> sartu=new Node<T> (elem) ;
		if (first.equals(null)) first=sartu;
		else{
			sartu.next=first;
			sartu.prev=first.prev;
			first.prev=sartu;
			first=sartu;
		}
	}

	public void addToRear(T elem) {
	// bukaeran gehitu
		Node<T> sartu=new Node<T> (elem) ;
		if (first.equals(null)) first=sartu;
		else{
			sartu.next=first;
			sartu.prev=first.prev;
			first.prev.next=sartu;
			first.prev=sartu;			
		}
	}
	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		Node<T> sartu=new Node<T> (elem) ;
		if(first.equals(null)) first=sartu;
		else{
			Node<T> current= first.next;
			while(!current.data.equals(target)&&!current.equals(first)){
				current=current.next;
			}
			if (current.data.equals(target)){
				if(current.equals(first)) addToFront(elem);
				else if (current.equals(first.prev)) addToRear(elem);
				else{
					sartu.next=current.next;
					sartu.prev=current;
					current.next.prev=sartu;
					current.next=sartu;
				}
			}
		}
	}
}
