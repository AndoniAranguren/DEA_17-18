package eginkizuna1;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

import org.junit.runner.manipulation.Sortable;

public class WebOrriZerrenda { //FN+F3 PA SABER DE DONDE SALE
	//Atributuak
	private TreeMap<WebOrria,WebOrria> listaWebOrri;
	private ArrayList<WebOrria> listaIdWebOrri;
	//Treemap WebOrriak index moduan eta WebOrrietara apuntatuz erraz atera ahal da id2String eta string2Id
	//Gainera oso azkarra izango da, eta memoriako puntu berera apuntatzen dutenez ez dute memoria extrarik xahutuko
	private static WebOrriZerrenda nireBurua;
	
	//Eraikitzailea
	private WebOrriZerrenda(){
		listaWebOrri= new TreeMap<WebOrria,WebOrria>();
		listaIdWebOrri= new ArrayList<WebOrria>();
	}
	public static WebOrriZerrenda getWebOrriZerrenda(){
		if(nireBurua==null)
			nireBurua = new WebOrriZerrenda();
		return nireBurua;
	}
	//Metodoak
	public void add(WebOrria pW){
		listaWebOrri.put(pW, pW);
		listaIdWebOrri.add(pW.getId(), pW);
	}
	public void add(List<WebOrria> pW){
		for(WebOrria web : pW) add(web); //WebOrri = tipo de dato (int, string... en este caso la clase) web = ind (nombre del indize)
	}
	public void remove(WebOrria pW) {
		listaWebOrri.remove(pW);
	}
	public void remove(ArrayList<WebOrria> pW) {
		for(WebOrria web : pW) remove(web);
	}
	public boolean contains(WebOrria pW){
		return listaWebOrri.containsKey(pW);
	}
	public String id2String(int pId){
		WebOrria web=id2Web(pId);
		return (web==null ? null : web.getUrl());	// [(x)? (x true bada) : (x false bada)]
	}
	public int string2Id(String pS){ //Web orria lortu eta bere string-a eskatu O(logn). Hnek weborrien string-ak[url] konparatzen ditu
		//Ezin da get() bat egin treemapearen key klasekoa ez dez ezerekin
		WebOrria web=string2Web(pS);
		return (web==null ? null : web.getId());
	}
	public LinkedList<String> irteerakoEstekak(String pS){
		LinkedList<String> listaString= null;
		if(pS!=null){
			LinkedList<WebOrria> listaWeb= string2Web(pS).getNora();
			listaString= new LinkedList<String>();
			for(WebOrria web: listaWeb)
				listaString.add(web.getUrl());
		}	
		return listaString;
	}
	public ArrayList<String> webOrdenatua(){
		LinkedList<WebOrria> listaWeb= new LinkedList<WebOrria>(listaWebOrri.values()); //Treemap alf-ki ordenatu batetik LinkedList batera
		ArrayList<String> listaString= new ArrayList<String>(); 
		
		for(WebOrria web: listaWeb) //Url-ak atera
			listaString.add(web.getUrl());
		
		return listaString;
	}
	public WebOrria id2Web(int pId){ //Web orria lortu O(1)
		return listaIdWebOrri.get(pId);
	}
	private WebOrria string2Web(String pS){ //Web orria lortu O(logn). Honek weborrien string-ak[url] konparatzen ditu
		//Ezin da get() bat egin treemapearen key klasekoa ez dez ezerekin
		WebOrria señuelo= new WebOrria(pS, 0);
		return listaWebOrri.get(señuelo);
	}
	public void datuakKargatu(String pHelbidea){ //Rellenar treemap O(n)
		WebOrria web=null;
		String linea;
		int totales= lineaTotalak(pHelbidea), kop=1,ehuneko=0;
		boolean loading= totales>1000000;

		System.out.println("\nWebOrriZerrendan datuak kargatzen...");
		try{
			Scanner entrada= new Scanner (new FileReader(pHelbidea)); //Scanner solo coge string, toda la linea
			if(loading) {
				System.out.print("[");
				for(int i =0; i<100;i++) System.out.print("-");
				System.out.println("]");
				System.out.print("[");
			}
			while(entrada.hasNext()){
				if(loading&&ehuneko!=(kop* 100)/totales) {
					ehuneko=(kop* 100)/totales;
					System.out.print("=");
				}
				linea=entrada.nextLine();
				web= new WebOrria(linea.split(" ")[0],Integer.parseInt(linea.split(" ")[1]));
				add(web);
//				listaArrayWebOrri.set(web.getId(), web); 
				kop++;
			}
			entrada.close();
			if(loading)System.out.println("]");
		}
		catch(IOException e){System.out.println("Beste helbide bat sar ezazu.");}

		System.out.println((kop-1)+ " weborri kargatu dira");
		System.out.println(listaWebOrri.size()+ " weborri ditu listak");
	}
	private int lineaTotalak(String pHeblidea) {
		int lines = 0;
		try {
			java.io.File file = new java.io.File(pHeblidea);
			java.io.LineNumberReader lineNumberReader = new java.io.LineNumberReader(new FileReader(file));
			lineNumberReader.skip(Long.MAX_VALUE);
			lines = lineNumberReader.getLineNumber();
			lineNumberReader.close();
		}catch(IOException e){
			
		}
		return lines;
	}
	public void webOrrienDatuakKargatu(String pHelbidea){ //WebOrri klaseko listak bete (listaNondik + listaNora)
		String linea;
		int nondik, nora;
		int totales= lineaTotalak(pHelbidea), kop=1,ehuneko=0;
		boolean loading= totales>1000000;
		try{
			Scanner entrada= new Scanner (new FileReader (pHelbidea));
			if(loading) {
				System.out.print("[");
				for(int i =0; i<100;i++) System.out.print("-");
				System.out.println("]");
				System.out.print("[");
			}
			while(entrada.hasNext()){
				if(loading&&ehuneko!=(kop* 100)/totales) {
					ehuneko=(kop* 100)/totales;
					System.out.print("=");
				}
				linea=entrada.nextLine();
				nondik=Integer.parseInt(linea.split(" ")[0]);
				nora=Integer.parseInt(linea.split(" ")[1]);
				listaIdWebOrri.get(nondik).addNora(listaIdWebOrri.get(nora)); //addNora = meter la web de nora en listaNora de la web Nondik
				listaIdWebOrri.get(nora).addNondik(listaIdWebOrri.get(nondik)); //addNondik = meter la web nondik en listaNondik de la web Nora
				kop++;
			}
			entrada.close();
			if(loading)System.out.println("]");
		}
		catch(IOException e){
			System.out.println("Sar ezazu beste helbide bat.");
			}

		System.out.println((kop-1)+ " weborri estekatu dira");
	}
	public void clear() {
		listaWebOrri.clear();
		listaIdWebOrri.clear();
		System.gc();
	}
	
	public boolean erlazionatuta(String a1, String a2) {
		return erlazionatutaPath(a1,a2)!=null;
	}
	
	public ArrayList<String> erlazionatutaPath(String a1, String a2){
		int kont=0;
		ArrayList<String> retArray= null;
		//a1 edo a2 ez badauka ezer ez egin
		if(string2Web(a1)!=null&&string2Web(a2)!=null){
			HashMap<String, String> path = new HashMap<String,String>();
			eginkizuna2.UnorderedDoubleLinkedList<WebOrria> nextWebs= 
					new eginkizuna2.UnorderedDoubleLinkedList<WebOrria>();
			
			WebOrria currentWeb=string2Web(a1);//O(nlogn)
			
			boolean found=false;
			nextWebs.addToRear(currentWeb);
			path.put(currentWeb.getUrl(), null);
			
			while(!found && !nextWebs.isEmpty()) {
				kont++;
				currentWeb=nextWebs.first();
				found=currentWeb.equals(a2);
				if(!found) {
					nextWebs.removeFirst();
					for(WebOrria web:currentWeb.getNora()) {
						if(!path.containsKey(web.getUrl())){
							nextWebs.addToRear(web);
							path.put(web.getUrl(), currentWeb.getUrl());
						}
					}
				}
			}
			System.out.println(kont+ " web konprobatu dira");
			if(found) {//Create the array we have to return
				String current= a2;
				retArray= new ArrayList<String>();
				while(current!=null) {	//Inverted array. O(m) m being the amount of webs linked between a1 and a2
					retArray.add(current);
					current=path.get(current);
				}
				for (int i = 0; i < retArray.size() / 2; ++i) { // Invert it back. O(m/2) only goes for half the array size
				    String elem = retArray.get(i); 
				    retArray.set(i,retArray.get( (retArray.size()-1) -i )); // we set i-th element with i-th element from the back
				    retArray.set( (retArray.size()-1) -i, elem);
				  }
			}
		}
			
		return retArray;
	}
	 public HashMap<String, Double> pageRank(){
	        //Post: emaitza, web-orri zerrendaren web-orri bakoitzaren PageRank algoritmoaren balioa da
	        HashMap<String, Double> prlist = new HashMap<String, Double>();
	        ArrayList<Integer> apuntadoreak = new ArrayList<Integer>(); //PageRank kalkulatzen ari garen weborrialdeari, apuntatzen dituen weborriak gorde. 
	        
	        int webkop=listaIdWebOrri.size();
	        int j = 0,estekakop=0;//Dagokion weborriaren zenbat esteka ateratzen diren gordeko du
	        double iterazioa=0,aux=0;
	        double batuketa=0.25*webkop;
	        double[] pr = new double [webkop]; //Pagerank balioa gorde iterazion bakoitzean
	        
	        resetPageRank();
	        
	        while (batuketa>0.0001){
	            if (j==webkop){
	                batuketa=batuketa-iterazioa;
	                j=0;
	            }
	            for(WebOrria web: this.id2Web(j).getNondik()){ //A-ri zein weborria apuntatzen dizkieten ikusi
	            	estekakop=web.getNora().size(); //Apuntadore baten esteken zerrendaren tamania
	                aux=aux+(pr[web.getId()]/estekakop);
	            }
	            pr[j]=((1-0.85)/webkop)+(0.85*aux); //PageRank  formula, 0.85=d
	            prlist.put(id2String(j), pr[j]);
	            iterazioa=iterazioa+pr[j];
	            j++;
	        }
	        return prlist;
	    }
	private void resetPageRank() {
		for(WebOrria web: listaIdWebOrri){
			web.setPageRank(0.25);
		}
	}
	
	public ArrayList<String> bilatzailea(String gakoHitz1, HashMap<String,Double> pageRanks){
		/* Post: Emaitza emandako gako-hitzak dituzten web-orrien zerrenda da, bere pagerank-aren arabera handienetik txikienera ordenatuta 
		   (hau da,lehenengo posizioetan pagerank handiena duten web-orriak agertuko dira)*/
		// The HashMap of pagerank is deprecated. We don't use it in this structure
		return bilatzailea(gakoHitz1,null,pageRanks);
	}
	
	public ArrayList<String> bilatzailea(String gakoHitz1,String gakoHitz2, HashMap<String,Double> pageRanks){
		/* Post: Emaitza emandako gako-hitzak dituzten web-orrien zerrenda da, bere pagerank-aren arabera handienetik txikienera ordenatuta 
		   (hau da,lehenengo posizioetan pagerank handiena duten web-orriak agertuko dira)*/
		// The HashMap of pagerank is deprecated. We don't use it in this structure
		
		pageRank();
		
		LinkedList<WebOrria> list=words2Webs(gakoHitz1);
		if(gakoHitz2!=null)list.addAll(words2Webs(gakoHitz2));
		list.sort(new Comparator<WebOrria>() {
			
			@Override
			public int compare(WebOrria o1, WebOrria o2) {
				return Double.compare(o2.getPageRank(), o1.getPageRank());
			}
			
		});
		
		//Pasatu ArrayList batera
		ArrayList<String> returnArray= new ArrayList<String>();
		Iterator<WebOrria> it= list.iterator();
		while (it.hasNext()){
			returnArray.add(it.next().getUrl());
		}
		
		return returnArray;
	}
	private LinkedList<WebOrria> words2Webs(String gakoHitz1){
		//Hiztegitik hitz hori dauzkaten web-ak hartzen ditu
		LinkedList<WebOrria> webs= new LinkedList<WebOrria>();
		java.util.Iterator<WebOrria> it=Hiztegia.getHiztegia().getHitza(gakoHitz1).iterator();
		while (it.hasNext()){
			webs.add(it.next());
		}
		return webs;
	}
}
