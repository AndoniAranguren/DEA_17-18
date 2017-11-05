package eginkizuna2;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	/**
	This method adds a T pElementent ordered by it's hasCode
	@param pElement is the T value it's being added and it should implement Comparable<T>
	@throws Exception When pElement is null
	@Cost_Function The cost is O(n)
	*/
	public void add(T pElement){
		if(pElement==null){
			try {
				throw new Exception("The value you input was null");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}else {
			Node<T> sartu= new Node<T>(pElement);
			boolean sartuta=false;
			if (first==null){
				first=sartu;
				first.next=sartu;
				first.prev=sartu;
				sartuta=true;
				count++;
			}
			else if(first.data.hashCode()<sartu.data.hashCode()){//lehenengoa
				sartu.next=first;
				sartu.prev=first.prev;
				first.prev.next=sartu;
				first.prev=sartu;
				first=sartu;
				sartuta=true;
				count++;
			}
			else{
				Node<T> current=first.next;
				while(!current.equals(first)&&!sartuta){ //error aqui
					if(current.data.hashCode()>sartu.data.hashCode()){//erditik
						sartu.prev=current.prev;
						sartu.next=current;
						current.prev.next=sartu;
						current.prev=sartu;
						sartuta=true;
						count++;
					}
					current=current.next;
				}
				if(!sartuta){//azkena
					sartu.next=first;
					sartu.prev=first.prev;
					first.prev.next=sartu;
					first.prev=sartu;
					sartuta=true;
					count++;
				}
			}
				try {
					if (!sartuta)
						throw new Exception();
				} catch (Exception e) {
					System.err.println(pElement.hashCode()+" badago listan");
				}
		}
	}
}
