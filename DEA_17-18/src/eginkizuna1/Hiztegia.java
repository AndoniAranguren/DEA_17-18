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
	private Hiztegia(){}
	public static Hiztegia getHiztegia(){
		if(nireBurua==null)
			nireBurua = new Hiztegia();
		return nireBurua;
	}
	
	//Metodoak
	public void add (java.util.ArrayList<String> pH){
		hiztegia.addAll(pH);
	}
	public void add (String pH){
		hiztegia.add(pH);
	}
	public void remove(String pH){
		hiztegia.remove(pH);
	}
	public boolean contains(String pH) {
		return hiztegia.contains(pH);
	}
	public void datuakKargatu(String pHelbidea){
		try{
			Scanner entrada= new Scanner (new FileReader (pHelbidea));
			while(entrada.hasNext()){
				add(entrada.next());
			}
		}
		catch(IOException e){
			System.out.println("Sar ezazu beste helbide bat.");
			}
	}
}
