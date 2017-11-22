package eginkizuna1;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

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
	private WebOrria id2Web(int pId){ //Web orria lortu O(1)
		return listaIdWebOrri.get(pId);
	}
	private WebOrria string2Web(String pS){ //Web orria lortu O(logn). Hnek weborrien string-ak[url] konparatzen ditu
		//Ezin da get() bat egin treemapearen key klasekoa ez dez ezerekin
		WebOrria señuelo= new WebOrria(pS, 0);
		return listaWebOrri.get(señuelo);
	}
	public void datuakKargatu(String pHelbidea){ //Rellenar treemap O(n)
		WebOrria web=null;
		String linea;
		int totales= lineaTotalak(pHelbidea), kop=1,ehuneko=0;
		boolean loading= totales>1000000;

		System.out.println("WebOrriZerrendan datuak kargatzen...");
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

		System.out.println((kop-1)+ " hitz kargatu dira");
		System.out.println(listaWebOrri.size()+ " hitz ditu listak");
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
	}
	
	public boolean erlazionatuta(String a1, String a2) {
		return erlazionatutaPath(a1,a2)!=null;
	}
	
	public ArrayList<String> erlazionatutaPath(String a1, String a2){

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
}
