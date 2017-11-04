package eginkizuna1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import eginkizuna2.UnorderedDoubleLinkedList;

public class Hiztegia {
	//Atributuak
	private HashMap<String,UnorderedDoubleLinkedList<WebOrria>> hiztegia;
	private static Hiztegia nireBurua;
	
	//Eraikitzailea
	private Hiztegia(){
		hiztegia= new HashMap<String,UnorderedDoubleLinkedList<WebOrria>>();
	}
	public static Hiztegia getHiztegia(){
		if(nireBurua==null)
			nireBurua = new Hiztegia();
		return nireBurua;
	}
	
	//Metodoak
	public void addWebOrria(LinkedList<String> pH, WebOrria pWeb){
		UnorderedDoubleLinkedList<WebOrria> aux;
		for(String hitza: pH) {
			aux=hiztegia.get(hitza);
			if(aux==null) {
				aux=new UnorderedDoubleLinkedList<WebOrria>();
			}
			aux.addToFront(pWeb);
			hiztegia.put(hitza, aux);
		}
	}
	public ArrayList<String> word2Webs(String pHitza){
		ArrayList<String> array= null;
		java.util.Iterator<WebOrria> it= hiztegia.get(pHitza).iterator();
		if(hiztegia.containsKey(pHitza)) {
			array= new ArrayList<String>();
			while(it.hasNext()) {
				array.add(it.next().getUrl());
			}
		}
		return array;
	}
	public void add (String pH){
		hiztegia.put(pH, null);
	}
	public void add (java.util.List<String> pH){
		for(String hitza: pH)
			add(hitza);
	}
	public boolean contains(String pH) {
		return hiztegia.containsKey(pH);
	}
	public void clear() {
		hiztegia.clear();
	}
	public void datuakKargatu(String pHelbidea){
		int kop=0;
		String hitza;
		try{
			Scanner entrada= new Scanner (new FileReader (pHelbidea));
			System.out.println("Hiztegian datuak kargatzen...");
			while(entrada.hasNext()){
				hitza= entrada.next();
				if(!contains(hitza)) {
					add(hitza);
					kop++;
				}
			}
		}
		catch(IOException e){
			System.out.println("Sar ezazu beste helbide bat.");
		}
		System.out.println(kop+ " hitz kargatu dira");
		System.out.println(hiztegia.size()+ " hitz ditu listak");
	}
}
