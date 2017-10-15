package eginkizuna1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Hiztegia {
	//Atributuak
	private HashMap<String,LinkedList<WebOrria>> hiztegia;
	private static Hiztegia nireBurua;
	
	//Eraikitzailea
	private Hiztegia(){
		hiztegia= new HashMap<String,LinkedList<WebOrria>>();
	}
	public static Hiztegia getHiztegia(){
		if(nireBurua==null)
			nireBurua = new Hiztegia();
		return nireBurua;
	}
	
	//Metodoak
	public void addWebOrria(LinkedList<String> pH, WebOrria pWeb){
		LinkedList<WebOrria> aux;
		for(String hitza: pH) {
			aux=hiztegia.get(hitza);
			if(aux==null) {
				aux=new LinkedList<WebOrria>();
			}
			aux.add(pWeb);
			hiztegia.put(hitza, aux);
		}
	}
	public ArrayList<String> word2Webs(String pHitza){
		ArrayList<String> array= null;
		if(hiztegia.containsKey(pHitza)) {
			array= new ArrayList<String>();
			for(WebOrria web :hiztegia.get(pHitza))
				array.add(web.getUrl());
		}
		return array;
	}
	public boolean add (String pH){
		return hiztegia.put(pH, null)!=null;
	}
	public boolean add (java.util.List<String> pH){
		boolean denaOndo=true;
		for(String hitza: pH) {
			if(denaOndo)
				denaOndo=add(hitza);
		}
		return denaOndo;
	}
	public boolean contains(String pH) {
		return hiztegia.containsKey(pH);
	}
	public void clear() {
		hiztegia.clear();
	}
	public void datuakKargatu(String pHelbidea){
		int kop=0;
		try{
			Scanner entrada= new Scanner (new FileReader (pHelbidea));
			System.out.println("Hiztegian datuak kargatzen...");
			while(entrada.hasNext()){
				if(add(entrada.next())) kop++;
			}
		}
		catch(IOException e){
			System.out.println("Sar ezazu beste helbide bat.");
		}
		System.out.println(kop+ " hitz kargatu dira");
		System.out.println(hiztegia.size()+ " hitz ditu listak");
	}
}
