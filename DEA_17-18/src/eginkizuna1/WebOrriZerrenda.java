package eginkizuna1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;

public class WebOrriZerrenda { //FN+F3 PA SABER DE DONDE SALE
	//Atributuak
	private TreeMap<WebOrria,WebOrria> listaWebOrri;
	//Treemap WebOrriak index moduan eta WebOrrietara apuntatuz erraz atera ahal da id2String eta string2Id
	//Gainera oso azkarra izango da, eta memoriako puntu berera apuntatzen dutenez ez dute memoria extrarik xahutuko
	private static WebOrriZerrenda nireBurua;
	
	//Eraikitzailea
	private WebOrriZerrenda(){
		listaWebOrri= new TreeMap<WebOrria,WebOrria>();
	}
	
	public static WebOrriZerrenda getWebOrriZerrenda(){
		if(nireBurua==null)
			nireBurua = new WebOrriZerrenda();
		return nireBurua;
	}
	//Metodoak
	public void add(WebOrria pW){
		listaWebOrri.put(pW, pW);
	}
	public void add(java.util.ArrayList<WebOrria> pW){
		for(WebOrria web : pW) add(web); //WebOrri = tipo de dato (int, string... en este caso la clase) web = ind (nombre del indize)
	}
	public void remove(WebOrria pW){
		listaWebOrri.remove(pW); //punto = metodo de la clase o por defekto
	}
	public void remove(java.util.ArrayList<WebOrria> pW){
		for(WebOrria web : pW) remove(web); //no punto = this.remove o metodo creado
	}
	public boolean contains(WebOrria pW){
		return listaWebOrri.containsKey(pW);
	}
	
	//Ezin da get() bat egin treemapearen key klasekoa ez dez ezerekin
	public String id2String(int pId){ //Id-a pasa, Web orria lortu eta bere url-a eskatu. Honek treemapa ateratzen du, array baten bihurtuz id-al konparatu ahal izateko.
		Iterator<WebOrria> it=listaWebOrri.values().iterator();
		WebOrria web= null;
		boolean jarraitu= true;
		while(it.hasNext()&&jarraitu){
			web=it.next();
			jarraitu=!web.equals(pId);
		}
		return (jarraitu ? null: web.getUrl());
	}
	
	public int string2Id(String pS){ //Url-a pasa, Web orria lortu eta bere string-a eskatu. Hnek weborrien string-ak[url] konparatzen ditu
		WebOrria aux= new WebOrria(pS, 0);
		return listaWebOrri.get(aux).getId();
	}
	public ArrayList<String> irteerakoEstekak(String pS){
		
		ArrayList<String> listaString= null;
		if(pS!=null){
			ArrayList<WebOrria> listaWeb= listaWebOrri.get(pS).getNora();
			listaString= new ArrayList<String>();
			for(WebOrria web: listaWeb)
				listaString.add(web.getUrl());
		}	
		return listaString;
	}
	
	public ArrayList<String> webOrdenatua(){
		
		ArrayList<WebOrria> listaWeb= new ArrayList<WebOrria>(listaWebOrri.values()); //Treemap alf-ki ordenatu batetik ArrayList batera
		ArrayList<String> listaString= new ArrayList<String>(); 
		for(WebOrria web: listaWeb) //Url-ak atera
			listaString.add(web.getUrl());
		
		return listaString;
	}
	
	public ArrayList<String> word2Webs(String pS){
		
		ArrayList<WebOrria> listaWeb= new ArrayList<WebOrria>(listaWebOrri.values()); //Treemap alf-ki ordenatu batetik ArrayList batera
		ArrayList<String> listaString= new ArrayList<String>(); 
		for(WebOrria web: listaWeb) //Gako hori daukan url-ak atera
			if(web.containsGakoa(pS))
				listaString.add(web.getUrl());
		
		return listaString;
	}
	
	public WebOrria id2Web(int pId){ //Pasas un id, y te devuelve una weborri
		return listaWebOrri.get(pId); //donde lo busca
	}
	
	public void datuakKargatu(String pHelbidea){ //Rellenar treemap
		WebOrria web=null;
		String url;
		int id;
		try{
			Scanner entrada= new Scanner (new FileReader(pHelbidea)); //Scanner solo coge string, toda la linea
			while(entrada.hasNext()){
				url=entrada.nextLine();
				id=Integer.parseInt(entrada.nextLine());  //Cuando tienes un numero y quieres scanearlo obligatorio hacerlo asi
				web= new WebOrria(url,id); 
				add(web);
			}
		}
		catch(IOException e){System.out.println("Beste helbide bat sar ezazu.");}
	}
	public void webOrrienDatuakKargatu(String pHelbidea){ //WebOrri klaseko listak bete (listaNondik + listaNora)
		int nondik;
		int nora;
		try{
			Scanner entrada= new Scanner (new FileReader (pHelbidea));
			while(entrada.hasNext()){
				nondik=Integer.parseInt(entrada.nextLine());
				nora=Integer.parseInt(entrada.nextLine());
				id2Web(nondik).addNora(id2Web(nora)); //addNora = meter la web de nora en listaNora de la web Nondik
				id2Web(nora).addNondik(id2Web(nondik)); //addNondik = meter la web nondik en listaNondik de la web Nora
			}
		}
		catch(IOException e){
			System.out.println("Sar ezazu beste helbide bat.");
			}
	}
}
