package eginkizuna1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class WebOrriZerrenda {
	//Atributuak
	private TreeMap<WebOrria,WebOrria> listaWebOrri;
	//Treemap WebOrriak index moduan eta WebOrrietara apuntatuz erraz atera ahal da id2String eta string2Id
	//Gainera oso azkarra izango da, eta memoriako puntu berera apuntatzen dutenez ez dute memoria extrarik xahutuko
	private WebOrriZerrenda nireBurua;
	
	//Eraikitzailea
	private WebOrriZerrenda(){}
	
	public WebOrriZerrenda getWebOrriZerrenda(){
		if(nireBurua==null)
			nireBurua = new WebOrriZerrenda();
		return nireBurua;
	}
	//Metodoak
	public void add(WebOrria pW){
		listaWebOrri.put(pW, pW);
	}
	public void add(java.util.ArrayList<WebOrria> pW){
		for(WebOrria web : pW) add(web);
	}
	public void remove(WebOrria pW){
		listaWebOrri.remove(pW);
	}
	public void remove(java.util.ArrayList<WebOrria> pW){
		for(WebOrria web : pW) remove(web);
	}
	public boolean contains(WebOrria pW){
		return listaWebOrri.containsKey(pW);
	}
	public String id2String(int pId){
		return listaWebOrri.get(pId).getUrl();
	}
	public int string2Id(String pS){
		return listaWebOrri.get(pS).getId();
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
	
	public void datuakKargatu(String pHelbidea){
		
		WebOrria web=null;
		String url;
		int id;
		try{	
			Scanner entrada= new Scanner (new FileReader(pHelbidea));
			while(entrada.hasNext()){
				url=entrada.nextLine();
				id=Integer.parseInt(entrada.nextLine());
				web= new WebOrria(url,id);
				add(web);
			}
		}
		catch(IOException e){System.out.println("Beste helbide bat sar ezazu.");}
	}
}
