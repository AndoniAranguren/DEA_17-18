package eginkizuna2;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){//compareTo ez da atzigarria T elementuekin, orduan bakoitza bere hasode-ari begira ordenatuko da, bakoitzak bakarra izango baitu, .equals==true ematen ez den bitartean.
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> sartu= new Node<T>(elem);
		boolean sartuta=false;
		if (first==null){
			first=sartu;
			first.next=sartu;
			first.prev=sartu;
		}
		else if(first.data.hashCode()>sartu.data.hashCode()){//lehenengoa
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
		if (!sartuta) System.out.println("Sartu nahi duzun datua badago jada listan.");
	}


}
