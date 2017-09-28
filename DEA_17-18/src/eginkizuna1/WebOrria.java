package eginkizuna1;

import java.util.ArrayList;
import java.util.Iterator;

public class WebOrria {
	
	private String url;
	private int id;
	
	private ArrayList<WebOrria> listaNondik = new ArrayList<WebOrria>();
	private ArrayList<WebOrria> listaNora = new ArrayList<WebOrria>();
	private ArrayList<Hitza> listaGakoa= new ArrayList<Hitza>();
	
	public WebOrria(String pUrl, int pId){
		url=pUrl;
		id=pId;
	}

	public void addNondik(WebOrria pObj){
		if(!listaNondik.contains(pObj)) listaNondik.add(pObj);
	}
	public void addNondik(ArrayList<WebOrria> pObj){
		for(WebOrria obj: pObj) addNondik(obj);
	}
	public void addNora(WebOrria pW){
		if(!listaNora.contains(pW)) listaNora.add(pW);
	}
	public void addNora(ArrayList<WebOrria> pObj){
		for(WebOrria obj: pObj) addNora(obj);
	}
	public void addGakoa(Hitza pH){
		if(!listaGakoa.contains(pH)) listaGakoa.add(pH);
	}
	public void addGakoa(ArrayList<Hitza> pObj){
		for(Hitza obj: pObj) addGakoa(obj);
	}
	
	public void removeNondik(Object pObj){
		listaNondik.remove((WebOrria)pObj);
	}
	public void removeNondik(ArrayList<WebOrria> pObj){
		for(WebOrria obj: pObj) listaNondik.remove(obj);
	}
	public void removeNora(Object pObj){
		listaNora.remove((WebOrria)pObj);
	}
	public void removeNora(ArrayList<WebOrria> pObj){
		for(WebOrria obj: pObj) listaNora.remove(obj);
	}
	public void removeGakoa(Object pObj){
		listaGakoa.remove((WebOrria)pObj);
	}
	public void removeGakoa(ArrayList<Hitza> pObj){
		for(Hitza obj: pObj) listaGakoa.remove(obj);
	}
	
	public ArrayList<WebOrria> getNondik(){
		return listaNondik;
	}
	public ArrayList<WebOrria> getNora(){
		return listaNora;
	}
	public ArrayList<Hitza> getHitza(){
		return listaGakoa;
	}
	
	public boolean containsNondik(WebOrria pObj){
		return listaNondik.contains(pObj);
	}
	public boolean containsNora(WebOrria pObj){
		return listaNora.contains(pObj);
	}
	public boolean containsNondik(Hitza pObj){
		return listaGakoa.contains(pObj);
	}
	
	public boolean urlBerdina(String pI){
		return url.equals(pI);
	}
	public boolean equals(WebOrria pW){
		return pW.urlBerdina(url);
	}
	
	public int compareAlf(String pU){
		return url.compareTo(pU);
	}
	public int compareTo(WebOrria pW){
		return pW.compareAlf(url);
	}
}