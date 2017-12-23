package eginkizuna1;

import java.util.LinkedList;

public class WebOrria implements Comparable<WebOrria>{
	//Atributuak
	private String url;
	private int id;
	private double pageRank;
	
	//ArrayList best for get from an index
	//LinkedList best for iteration or adding
	private LinkedList<WebOrria> listaNondik = new LinkedList<WebOrria>();
	private LinkedList<WebOrria> listaNora = new LinkedList<WebOrria>();
	
	//Eraikitzailea
	public WebOrria(String pUrl, int pId){
		pageRank=0;
		url=pUrl;
		id=pId;
		Hiztegia.getHiztegia().addWebOrria(getGakoa(),this);
	}
	private LinkedList<String> web2Words(String pUrl) {
		//Ezkerretik ezkumara atera ahal duen hitz guztiak
		//bilatzen duena. Hitzez hitz ateraz eta gero guztiak List batean bueltatuz
		LinkedList<String> gakoak= new LinkedList<String>();		
		Hiztegia hiztegi=Hiztegia.getHiztegia();
		String[] urlMoztuta;
		if(pUrl.contains("\\.")) {
			urlMoztuta=pUrl.split("\\.");
		}else {
			urlMoztuta= new String[]{pUrl,""};
		}
			String hitza;
	
			for(int ind=0; ind<=urlMoztuta[0].length(); ind++) {
				for(int ind2=ind; ind2<=urlMoztuta[0].length(); ind2++) {
					hitza=urlMoztuta[0].substring(ind, ind2);
					if(hiztegi.contains(hitza)) {//||(hitza.length()==1)) {
						if(!gakoak.contains(hitza))gakoak.add(hitza);
					}
				}
			}
	//		for(int ind=1; ind<urlMoztuta.length; ind++) {
	//			gakoak.add("." + urlMoztuta[ind]);
	//		}
		return gakoak;
	}

	//Metodoak
	public void addNondik(WebOrria pObj){ //Pa meter uno si no esta
		if(!listaNondik.contains(pObj)) listaNondik.add(pObj);
	}
	public void addNora(WebOrria pW){
		if(!listaNora.contains(pW)) listaNora.add(pW);
	}
	public void removeNondik(Object pObj){
		listaNondik.remove((WebOrria)pObj);
	}
	public void removeNora(Object pObj){
		listaNora.remove((WebOrria)pObj);
	}
	public LinkedList<WebOrria> getNondik(){
		return listaNondik;
	}
	public LinkedList<WebOrria> getNora(){
		return listaNora;
	}
	public LinkedList<String> getGakoa(){
		return web2Words(url);
	}
	public String getUrl(){
		return (this.url);
	}
	public int getId(){
		return (this.id);
	}
	public boolean containsNondik(WebOrria pObj){
		return listaNondik.contains(pObj);
	}
	public boolean containsNora(WebOrria pObj){
		return listaNora.contains(pObj);
	}
	public boolean containsGakoa(String pObj){
		return web2Words(url).contains(pObj);
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
	public int compareTo(String pU){
		return url.compareTo(pU);
	}
	public int compareTo(WebOrria pW){
		return pW.compareTo(url)*(-1);//Bider -1 buelta ematen diolako
	}
	public double getPageRank() {
		return pageRank;
	}
	public void setPageRank(double pageRank) {
		this.pageRank = pageRank;
	}
}