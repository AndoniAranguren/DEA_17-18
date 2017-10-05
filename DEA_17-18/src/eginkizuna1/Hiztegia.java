package eginkizuna1;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Hiztegia {
	//Atributuak
	private HashSet<String> hiztegia;
	private static Hiztegia nireBurua;
	
	//Eraikitzailea
	private Hiztegia(){
		hiztegia=new HashSet<String>();
	}
	public static Hiztegia getHiztegia(){
		if(nireBurua==null)
			nireBurua = new Hiztegia();
		return nireBurua;
	}
	
	//Metodoak
	public boolean add (java.util.ArrayList<String> pH){
		return hiztegia.addAll(pH);
	}
	public boolean add (String pH){
		return hiztegia.add(pH);
	}
	public boolean remove(java.util.ArrayList<String> pH){
		return hiztegia.removeAll(pH);
	}
	public boolean remove(String pH){
		return hiztegia.remove(pH);
	}
	public boolean contains(String pH) {
		return hiztegia.contains(pH);
	}
	public void clear() {
		hiztegia.clear();
	}
	public void datuakKargatu(String pHelbidea){
		int kop=0;
		try{
			Scanner entrada= new Scanner (new FileReader (pHelbidea));
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
