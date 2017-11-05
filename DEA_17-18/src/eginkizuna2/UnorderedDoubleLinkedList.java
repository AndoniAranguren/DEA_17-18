package eginkizuna2;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	/**
	This method adds a T pElementent to the front of the list
	@param pElement is the T value it's being added
	@throws Exception When pElement is null
	@Cost_Function The cost is O(1)
	*/
	public void addToFront(T pElement) {
	// hasieran gehitu
		if(pElement==null){
			try {
				throw new Exception("The the value you input was null, nothing was added to the front");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}else{
			Node<T> sartu=new Node<T> (pElement) ;
			if (first==null){ 
				first=sartu;
				first.next=first;
				first.prev=first;
				count++;
			}
			else{
				sartu.next=first;
				sartu.prev=first.prev;
				first.prev=sartu;
				first=sartu;
				count++;
			}
		}
	}

	/**
	This method adds a T pElementent to the back of the list
	@param pElement is the T value it's being added
	@throws Exception When pElement is null
	@Cost_Function The cost is O(1)
	*/
	public void addToRear(T pElement) {
	// bukaeran gehitu
		if(pElement==null){
			try {
				throw new Exception("The the value you input was null, nothing was added");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}else{
			Node<T> sartu=new Node<T> (pElement) ;
			if (first==null){
				first=sartu;
				first.next=first;
				first.prev=first;
				count++;
			}
			else{
				sartu.next=first;
				sartu.prev=first.prev;
				first.prev.next=sartu;
				first.prev=sartu;
				count++;
			}
		}
			
	}
	
	/**
	This method adds  pElement after pTarget
	@param pElement is the T value it's being added, after pTarget
	@throws Exception When pElement or pTarget is null
	@Cost_Function The cost is O(n)
	*/
	public void addAfter(T pElement, T pTarget) {
		if(pElement==null || pTarget==null){
			try {
				throw new Exception("At least one of the values you input was null, nothing was added");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}else {
			Node<T> sartu=new Node<T> (pElement) ;
			if(first!=null){
				Node<T> current= first.next;
				while(!current.data.equals(pTarget)&&!current.equals(first)){
					current=current.next;
				}
				if (current.data.equals(pTarget)){
					if (current.equals(first.prev)) addToRear(pElement);
					else{
						sartu.next=current.next;
						sartu.prev=current;
						current.next.prev=sartu;
						current.next=sartu;
						count++;
					}
				}
			}
		}	
	}
}
