package WebOrria;

import java.util.ArrayList;

public class Hiztegia {
	private ArrayList<Hitza> hitzak;
	
	public void add (ArrayList<Hitza> pH){
		hitzak.addAll(pH);
	}
	public void add (Hitza pH){
		hitzak.add(pH);
	}
	public Hitza get(int pInd){
		return this.get(pInd);
	}
	public void remove(Hitza pH){
		hitzak.remove(pH);
	}
}
