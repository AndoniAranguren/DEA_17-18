package eginkizuna1;

import java.util.ArrayList;

public class WebOrria implements Comparable<WebOrria>{
	//Atributuak
	private String url;
	private int id;
	
	private ArrayList<WebOrria> listaNondik = new ArrayList<WebOrria>();
	private ArrayList<WebOrria> listaNora = new ArrayList<WebOrria>();
	private ArrayList<String> listaGakoa= new ArrayList<String>();
	
	//Eraikitzailea
	public WebOrria(String pUrl, int pId){
		url=pUrl;
		id=pId;
		listaGakoa=web2Words(url);
	}

	private ArrayList<String> web2Words(String pUrl) {
		ArrayList<String> gakoak= new ArrayList<String>(), arrayAux=null;		
		Hiztegia hiztegi=Hiztegia.getHiztegia();
		String aux=pUrl, hitza;
		boolean jarraitu=true;
		int ind=0;
		
		while(jarraitu && url.isEmpty()) {
			hitza=aux.substring(0,pUrl.length()-ind);
			if(hiztegi.contains(hitza)) {
					arrayAux=web2Words(aux.substring(pUrl.length()-ind,aux.length()));
					if(arrayAux!=null||aux.length()==0) {
						gakoak.add(hitza);
						gakoak.addAll(arrayAux);
						jarraitu=false;
					}
			}else
				ind++;
		}
		return gakoak;
	}

	//Metodoak
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
	public void addGakoa(String pObj){
		if(!listaGakoa.contains(pObj)) listaGakoa.add(pObj);
	}
	public void addGakoa(ArrayList<String> pObj){
		for(String obj: pObj) addGakoa(obj);
	}
	
	public void removeNondik(Object pObj){
		listaNondik.remove((WebOrria)pObj);
	}
	public void removeNondik(ArrayList<WebOrria> pObj){
		for(WebOrria obj: pObj) removeNondik(obj);
	}
	public void removeNora(Object pObj){
		listaNora.remove((WebOrria)pObj);
	}
	public void removeNora(ArrayList<WebOrria> pObj){
		for(WebOrria obj: pObj) removeNora(obj);
	}
	public void removeGakoa(String pObj){
		listaGakoa.remove(pObj);
	}
	public void removeGakoa(ArrayList<String> pObj){
		for(String obj: pObj) removeGakoa(obj);
	}
	
	public ArrayList<WebOrria> getNondik(){
		return listaNondik;
	}
	public ArrayList<WebOrria> getNora(){
		return listaNora;
	}
	public ArrayList<String> getGakoa(){
		return listaGakoa;
	}
	public String getUrl(){
		return url;
	}
	public int getId(){
		return id;
	}
	
	public boolean containsNondik(WebOrria pObj){
		return listaNondik.contains(pObj);
	}
	public boolean containsNora(WebOrria pObj){
		return listaNora.contains(pObj);
	}
	public boolean containsGakoa(String pObj){
		return listaGakoa.contains(pObj);
	}
	
	public boolean equals(int pI){ 
		//Deskribapena: Id-etik String-a ateratzeko
		//Aurrebaldintza: Id batek beti url berdina izatea, eta alderantziz. Url eta id-ak ez errepikatzea
		return (id==pI);
	}
	public boolean equals(String pUrl){
		//Deskribapena: String-etik Id-a ateratzeko
		//Aurrebaldintza: Id batek beti url berdina izatea, eta alderantziz. Url eta id-ak ez errepikatzea
		return url.equals(pUrl);
	}
	public boolean equals(WebOrria pW){
		return pW.equals(id);
	}
	public int compareAlf(String pU){
		return url.compareTo(pU);
	}
	public int compareTo(WebOrria pW){
		return pW.compareAlf(url);
	}
	
}