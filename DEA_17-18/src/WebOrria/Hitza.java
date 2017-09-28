package WebOrria;

import java.util.ArrayList;

public class Hitza {
	private String hitza;
	
	public int compareTo(Hitza pH){
		return hitza.compareTo(pH.hitza);
	}
	public boolean equals(Hitza pH){
		return hitza.equals(pH.hitza);
	}
	public boolean izenBerdin(Hitza pH){
		return hitza.equals(pH);
	}

}
