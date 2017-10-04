package eginkizuna1;

import java.util.HashSet;

import WebOrria.Hitza;

public class Hiztegia {
	private HashSet<Hitza> hitzak;
	
	public void add (java.util.ArrayList<Hitza> pH){
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
